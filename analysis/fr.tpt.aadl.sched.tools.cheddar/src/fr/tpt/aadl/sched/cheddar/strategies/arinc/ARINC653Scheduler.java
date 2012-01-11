package fr.tpt.aadl.sched.cheddar.strategies.arinc ;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;

import fr.tpt.aadl.launch.PluginActivator ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.model.SchedulerPipeline ;

public class ARINC653Scheduler implements SchedulerPipeline
{

  private static String FLAG_NUMBER_OF_SLOTS = "<<number_of_slots>>" ;
  private static String FLAG_NUMBER_OF_PARTITIONS = "<<number_of_partitions>>" ;

  private static String FLAG_SLOTS_DURATION = "<<slots_duration>>" ;
  private static String FLAG_SLOTS_PARTITION = "<<slots_partition>>" ;
  private static String FLAG_SLOTS_SLICEOUT = "<<slots_sliceout>>" ;

  private String buffer = "" ;
  private boolean error = false ;

  private int[] slotToPartition = null ;
  private int[] slotToDuration = null ;
  private int[] slotToSliceout = null ;

  private int partitions = 0 ;

  protected CheddarModel model = null ;

  public ARINC653Scheduler()
  {
    try
    {
      buffer = PluginActivator.getInstance().getARINC653Template() ;
    }
    catch(Exception e)
    {
      System.err.println("[AutomatonCompletion] " + e.getLocalizedMessage()) ;
      error = true ;
    }
  }

  public boolean hasError()
  {
    return error ;
  }

  public int getMajorFrame()
  {
    int MAF = 0 ;

    for(int s = 0 ; s < slotToDuration.length ; s++)
    {
      MAF += slotToDuration[s] ;
    }

    return (int) Math.ceil((float) (MAF / model.getScaling())) ;
  }

  public void saveTo(String outputPath)
        throws IOException
  {
    String fullAutomaton = completeAutomaton() ;
    File f = new File(outputPath) ;

    if(!f.exists())
    {
      f.createNewFile() ;
    }

    BufferedWriter writer = new BufferedWriter(new FileWriter(f)) ;
    writer.write(fullAutomaton) ;
    writer.close() ;
  }

  private String completeAutomaton()
  {
    String res ;
    String code_slots_duration = "" ;
    String code_slots_partition = "" ;
    String code_slots_sliceout = "" ;

    for(int s = 0 ; s < slotToDuration.length ; s++)
    {
      int duration =
            (int) Math.ceil((double) (slotToDuration[s] / model.getScaling())) ;
      int partition = slotToPartition[s] ;
      int sliceout = slotToSliceout[s] ;
      code_slots_duration += "\n\tslot_duration(" + s + "):=" + duration + ";" ;
      code_slots_partition +=
            "\n\tslot_partition(" + s + "):=" + partition + ";" ;
      code_slots_sliceout += "\n\tslot_sliceout(" + s + "):=" + sliceout + ";" ;
    }

    res = buffer.replace(FLAG_NUMBER_OF_SLOTS, slotToDuration.length + "") ;
    res = res.replace(FLAG_NUMBER_OF_PARTITIONS, partitions + "") ;
    res = res.replace(FLAG_SLOTS_DURATION, code_slots_duration) ;
    res = res.replace(FLAG_SLOTS_PARTITION, code_slots_partition) ;
    res = res.replace(FLAG_SLOTS_SLICEOUT, code_slots_sliceout) ;
    return res ;
  }

  public void setSlotsCount(int slots)
  {
    slotToPartition = new int[slots] ;
    slotToDuration = new int[slots] ;
    slotToSliceout = new int[slots] ;

    for(int i = 0 ; i < slots ; i++)
    {
      slotToSliceout[i] = 0 ;
    }
  }

  public void setPartitionCount(int partitions)
  {
    this.partitions = partitions ;
  }

  public void setPartitionAtSlot(int slot,
                                 int p)
  {
    slotToPartition[slot] = p ;
  }

  @Override
  public void setSliceout(int sliceout,
                          Object slot)
  {
    slotToSliceout[(Integer) slot] = sliceout ;
  }

  public void setSlotSliceout(int slot,
                              int sliceout)
  {
    slotToSliceout[slot] = sliceout ;
  }

  public void setSlotDuration(int slot,
                              int d)
  {
    slotToDuration[slot] = d ;
  }

  public int getSlotStartTime(int slot)
  {
    int start = 0 ;

    for(int indexS = 0 ; indexS < slot ; indexS++)
    {
      start += slotToDuration[indexS] ;
    }

    return start ;
  }

  public int[] getPartitionSlots(int partition)
  {
    int size = 0 ;

    for(int s = 0 ; s < slotToPartition.length ; s++)
    {
      if(slotToPartition[s] == partition)
      {
        size++ ;
      }
    }

    int[] pSlots = new int[size] ;
    int i = 0 ;

    for(int s = 0 ; s < slotToPartition.length ; s++)
    {
      if(slotToPartition[s] == partition)
      {
        pSlots[i] = s ;
        i++ ;
      }
    }

    return pSlots ;
  }

  public int localTick(int globalTick,
                       int partition)
  {
    int localTick = 0 ;
    int slot = 0 ;
    int slotConsumedTime = 0 ;

    for(int t = 0 ; t < globalTick ; t++)
    {
      slotConsumedTime++ ;
      int slotDuration =
            (int) Math
                  .ceil((double) (slotToDuration[slot] / model.getScaling())) ;
      int slotPartition = slotToPartition[slot] ;

      if(slotPartition == partition)
      {
        localTick++ ;
      }

      if(slotConsumedTime == slotDuration)
      {
        slot = slot + 1 ;
        slotConsumedTime = 0 ;
      }
    }

    return localTick ;
  }

  @Override
  public void setModel(CheddarModel model)
  {
    this.model = model ;
  }
}
