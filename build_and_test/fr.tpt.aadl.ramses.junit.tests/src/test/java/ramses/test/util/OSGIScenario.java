package ramses.test.util;


public abstract class OSGIScenario extends Scenario
{
 
  protected void setupCommandLineArgsPrefix(StringBuilder args)
  {
    
    if(ramses_dir != null)
    {
      args.append(ramses_dir) ;
    }
    
    args.append("osate2-cli.app/Contents/MacOS/osate2-cli") ;
  }

  
}