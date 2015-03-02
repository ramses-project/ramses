package ramses.test.util;


public abstract class OSGIScenario extends Scenario
{

	
  protected void setupCommandLineArgsPrefix(StringBuilder args)
  {
    String debug = "true";
    parameters.put("debug", debug);
    
    if(ramses_dir != null)
    {
      args.append(ramses_dir) ;
    }
    
    args.append("osate2-cli") ;
  }

  
}