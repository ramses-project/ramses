package fr.tpt.aadl.flow.extraction.seq ;

import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;

public abstract class CallSequenceAnalyzer extends ExecutionAnalyzer
{

  protected final ExtractionContext ctxt ;

  public CallSequenceAnalyzer(
                              ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    this.ctxt = ctxt ;
  }

}
