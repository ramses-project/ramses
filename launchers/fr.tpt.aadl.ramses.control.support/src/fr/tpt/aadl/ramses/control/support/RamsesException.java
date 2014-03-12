package fr.tpt.aadl.ramses.control.support;

public abstract class RamsesException extends Exception
{
  protected String _encapsMessage ;  
  
  /**
   * 
   */
  private static final long serialVersionUID = -8622765345145000268L ;
  
  public RamsesException(String errorMessage)
  {
    super(errorMessage) ;
  }
  
  public RamsesException(Throwable e)
  {
    super(e) ;
  }
  
  /**
   * Rethrow encapsulation
   * 
   * @param errorMessage the encapsulating message
   * @param e the exception been encapsulated
   */
  public RamsesException(String errorMessage, Throwable e)
  {
    super(errorMessage, e) ;
    _encapsMessage = errorMessage ;
  }
  
  @Override
  public String getMessage()
  {
    return formatRethrowMessage(_encapsMessage, super.getCause()) ;
  }
  
  public static String formatRethrowMessage(String initialMessage,
                                            Throwable ex)
  {
    if(ex != null && ex.getMessage() != null)
    {
      initialMessage += " (" + ex.getMessage() + ')' ;
    }
      
    return initialMessage ;
  }
}