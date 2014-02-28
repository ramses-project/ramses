package fr.tpt.aadl.ramses.analysis.eg.seq;

import java.util.List ;

import org.osate.aadl2.SubprogramCall ;

import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;

public class CallSequence2EG
{
  private final List<SubprogramCall> callSequence;
  
  public CallSequence2EG (List<SubprogramCall> callSequence)
  {
    this.callSequence = callSequence;
  }
  
  public EGNode toEG()
  {
    return new EGNode("Call sequence");
  }
}
