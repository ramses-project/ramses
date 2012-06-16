package fr.tpt.aadl.sched.cheddar ;

public class CheddarOptions
{

  /** Cheddar simulator command-line. */
  public static final String CHEDDAR_SIMULATOR_PATH =
        "/home/borde/Install/CHEDDAR2/trunk/src/framework_examples/build_schedule_from_xml" ;
  public static final String CHEDDAR_TOOL_NAME =
        "/home/borde/Install/CHEDDAR2/trunk/src/binaries/bin/debug/cheddar_d" ;

  public static final boolean CHEDDAR_EXPORT_CRITICAL_SECTIONS = true ;

  /** Enabled, this option use a unique address space for all tasks,
   * in order to allow buffers between partitions or nodes.
   */
  public static final boolean CHEDDAR_USES_GLOBAL_BUFFERS = false ;

  /** Debug option. */
  public static boolean CHEDDAR_DEBUG = false ;

  private CheddarOptions()
  {
  }

}
