package fr.tpt.aadl.sched.cheddar ;

public class CheddarOptions
{

  /** Cheddar simulator command-line. */
  public static final String CHEDDAR_SIMULATOR_PATH = initCheddarPath() +
        "/framework_examples/build_schedule_from_xml";
  public static final String CHEDDAR_TOOL_NAME = initCheddarPath() +
        "/binaries/bin/debug/cheddar_d" ;

  public static final boolean CHEDDAR_EXPORT_CRITICAL_SECTIONS = true ;

  /** Enabled, this option use a unique address space for all tasks,
   * in order to allow buffers between partitions or nodes.
   */
  public static final boolean CHEDDAR_USES_GLOBAL_BUFFERS = false ;

  /** Debug option. */
  public static boolean CHEDDAR_DEBUG = false ;

  private static String initCheddarPath()
  {
    String CHEDDAR_PATH = "CHEDDAR_PATH";
    String path = System.getenv(CHEDDAR_PATH);
    if(path!=null && path.isEmpty())
    {
      path=System.getProperty(CHEDDAR_PATH);
    }
    return path;
  }
  
  private CheddarOptions()
  {
  }

}
