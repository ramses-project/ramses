package fr.tpt.aadl.ramses.control.support.utils;

public class WaitMonitor extends Thread
{
  private Command _action ; 
  
  private Exception _caughtException = null ;
  
  private int _exitCode = Command.UNSET;
  
  public WaitMonitor(Command action)
  {
    _action = action ;
  }
  
  @Override
  public void run()
  {
    try
    {
      _exitCode = _action.runBlockingCommand();
    }
    catch(Exception e)
    {
      _caughtException = e ;
      _exitCode = Command.FATAL ;
    }
    finally
    {
      synchronized(_action) {_action.notifyAll();}
    }
  }
  
  public Exception getCaughtException()
  {
    return _caughtException ;
  }
  
  public int waitAndCheck(int period) throws InterruptedException
  {
    long currentTime ;
    long beforeWaiting ;
    boolean hasToContinue = true ;
     
    while(hasToContinue)
    {
      beforeWaiting = System.currentTimeMillis() ;
      
      synchronized(_action)
      {
        _action.wait(period) ;
      }
      
      currentTime = System.currentTimeMillis() ;

      // operation has finished before timeout.
      if(beforeWaiting + period > currentTime)
      {
        hasToContinue = false ;
      }
      else
      {
        // Operation has been canceled.
        if(_action.isCanceled())
        {
          hasToContinue = false ;
          _exitCode = Command.CANCEL ;
        }
        else 
        {
          // Operation is not complete and has not been canceled.
          continue ;
        }
      }
    }
    
    return _exitCode ;
  }
}