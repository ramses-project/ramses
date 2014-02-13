package fr.tpt.aadl.ramses.util.generation;

import java.io.File ;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;

public abstract class AbstractAadlToCMakefileUnparser extends AbstractMakefileUnparser 
{
  protected static final String C_PERIODIC_DELAYED_RUNTIME_DIR =
                                         "/C_runtime/PeriodicDelayed_runtime/" ; 
 
  @Override
  protected void setupCommonDirs()
  {
    // Add Dir of C PeriodicDelayed runtime
    File cPeriodicDelayedRuntimeDir;
    cPeriodicDelayedRuntimeDir = new File(RamsesConfiguration.getPredefinedResourceDir().getAbsolutePath() +
                                          C_PERIODIC_DELAYED_RUNTIME_DIR);
    
    _includeDirManager.addCommonDependency(cPeriodicDelayedRuntimeDir);
  }
}