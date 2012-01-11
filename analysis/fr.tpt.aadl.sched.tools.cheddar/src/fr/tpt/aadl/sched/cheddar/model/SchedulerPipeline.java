package fr.tpt.aadl.sched.cheddar.model ;

import java.io.IOException ;

public interface SchedulerPipeline
{

  public void setModel(CheddarModel model) ;

  public void setSliceout(int sliceout,
                          Object arg) ;

  public void saveTo(String outputPath)
        throws IOException ;
}
