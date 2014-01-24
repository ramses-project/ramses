package fr.tpt.aadl.flow.extraction.util ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.SubprogramSubcomponent ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.flow.extraction.ExecutionAnalyzer ;
import fr.tpt.aadl.flow.model.RTActionType ;
import fr.tpt.aadl.ramses.util.properties.AadlUtil;

public class ComputationUtil
{

  private ComputationUtil()
  {
  }

  public static RTActionType getSubprogramActionType(NamedElement e)
  {
    /*String synchroKind = "NotSyncFunction";
    try
    {
      synchroKind = PropertyUtils.getEnumValue(e, "Synchronization_Function");
    }
    catch (Exception ex){}
    
    if (synchroKind.equals("GetResource"))
      return RTActionType.WaitResource;
    else if (synchroKind.equals("ReleaseResource"))
      return RTActionType.ReleaseResource;
    else if (synchroKind.equals("WaitTaskNextActivation"))
      return RTActionType.WaitTaskNextActivation;
    else if (synchroKind.equals("ReadPort"))
      return RTActionType.ReadPort;
    else if (synchroKind.equals("WritePort"))
      return RTActionType.WritePort;
    else
      return RTActionType.GenericCall; *//** Default case. */
    if(e.getName().equals("Get_Resource"))
    {
      return RTActionType.WaitResource ;
    }
    else if(e.getName().equals("Release_Resource"))
    {
      return RTActionType.ReleaseResource ;
    }
    else
    {
      return RTActionType.Compute ;
    }
  }

  public static int getElementMaxDuration(NamedElement e,
                                          ExecutionAnalyzer a)
  {
    Double d = 0.0 ;

    try
    {
      NumberValue nv = PropertyUtils.getMaxRangeValue(e, "Compute_Execution_Time") ;
      d = nv.getScaledValue(AadlUtil.getPrecision(e)) ;
      return d.intValue();
    }
    catch(Exception ex)
    {
      if(e instanceof SubprogramSubcomponent)
      {
        SubprogramSubcomponent sub = (SubprogramSubcomponent) e ;

        if(sub.getClassifier() != null)
        {
          return getElementMaxDuration(sub.getClassifier(), a) ;
        }
      }
      else
      {
        a.reportWarning(e, "No specified computation time for element " +
                              e.getName()) ;
      }
    }

    return d.intValue() ;
  }

  public static int getElementMinDuration(NamedElement e,
                                          ExecutionAnalyzer a)
  {
    Double d = 0.0 ;

    try
    {
      NumberValue nv = PropertyUtils.getMinRangeValue(e, "Compute_Execution_Time") ;
      d = nv.getScaledValue(AadlUtil.getPrecision(e)) ;
      return d.intValue();
    }
    catch(Exception ex)
    {
      if(e instanceof SubprogramSubcomponent)
      {
        SubprogramSubcomponent sub = (SubprogramSubcomponent) e ;

        if(sub.getClassifier() != null)
        {
          return getElementMinDuration(sub.getClassifier(), a) ;
        }
      }
      else
      {
        a.reportWarning(e, "No specified computation time for element " +
                              e.getName()) ;
      }
    }

    return d.intValue() ;
  }

  /*
  private static int getSubprogramMaxDuration(Subprogram s, ExecutionAnalyzer a)
  {
    int res = 0;
    for(Element e : s.getOwnedElements())
    {
      if (e instanceof SubprogramCallSequence)
      {
        SubprogramCallSequence seq = (SubprogramCallSequence) e;
  
        for(CallSpecification eCall : seq.getOwnedCallSpecifications())
        {
          if (eCall instanceof SubprogramCall)
          {
            SubprogramCall call = (SubprogramCall) eCall;
            Subprogram called = (Subprogram) call.getCalledSubprogram();
            res += getElementMaxDuration(called, a);
          }
        }
      }
    }
    return res;
  }
  
  
  private static int getSubprogramMinDuration(Subprogram s, ExecutionAnalyzer a)
  {
    int res = 0;
    for(Element e : s.getOwnedElements())
    {
      if (e instanceof SubprogramCallSequence)
      {
        SubprogramCallSequence seq = (SubprogramCallSequence) e;
  
        for(CallSpecification eCall : seq.getOwnedCallSpecifications())
        {
          if (eCall instanceof SubprogramCall)
          {
            SubprogramCall call = (SubprogramCall) eCall;
            Subprogram called = (Subprogram) call.getCalledSubprogram();
            res += getElementMinDuration(called, a);
          }
        }
      }
    }
    return res;
  }*/
}
