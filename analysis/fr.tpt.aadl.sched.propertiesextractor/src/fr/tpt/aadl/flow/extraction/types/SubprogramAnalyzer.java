package fr.tpt.aadl.flow.extraction.types ;

import org.osate.aadl2.Classifier ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;
import fr.tpt.aadl.flow.extraction.ExtractionContext ;
import fr.tpt.aadl.flow.extraction.ba.types.SubprogramAA ;
import fr.tpt.aadl.flow.extraction.seq.types.SubprogramSA ;
import fr.tpt.aadl.flow.extraction.util.BehaviorAnnexUtil ;
import fr.tpt.aadl.flow.model.RTAction ;

public class SubprogramAnalyzer extends ExecutionAnalyzer
{

  private final SubprogramAA spgAA ;
  private final SubprogramSA spgSA ;

  public SubprogramAnalyzer(
                            ExtractionContext ctxt)
  {
    super(ctxt.getErrManager()) ;
    spgAA = new SubprogramAA(ctxt) ;
    spgSA = new SubprogramSA(ctxt) ;
  }

  public RTAction extractFrom(ComponentInstance spg,
                              RTAction lastAction)
  {
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg) ;

    if(ba != null)
    {
      return spgAA.extractFrom(ba, lastAction) ;
    }
    else
    {
      return spgSA.extractFrom(spg, lastAction) ;
    }
  }

  public RTAction extractFrom(Classifier spg,
                              RTAction lastAction)
  {
    BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg) ;

    if(ba != null)
    {
      return spgAA.extractFrom(ba, lastAction) ;
    }
    else
    {
      return spgSA.extractFrom(spg, lastAction) ;
    }
  }
}
