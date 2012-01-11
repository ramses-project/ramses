package fr.tpt.aadl.flow.analysis.util ;

import fr.tpt.aadl.flow.model.RTAction ;
import fr.tpt.aadl.flow.model.RTActionType ;

public class SequenceUtil
{

  private SequenceUtil()
  {
  }

  public static RTAction getFirstAfterSequenceOf(RTActionType sequenceType,
                                                 RTAction start)
  {
    RTAction current = start ;

    while(current != null && (current.getType() != sequenceType))
    {
      current = next(current) ;
    }

    while(current != null)
    {
      if(current.getType() != sequenceType)
      {
        return current ;
      }

      current = next(current) ;
    }

    return null ;
  }

  public static RTAction getFirstOf(RTActionType sequenceType,
                                    RTAction start)
  {
    RTAction current = start ;

    while(current != null)
    {
      if(current.getType() == sequenceType)
      {
        return current ;
      }

      current = next(current) ;
    }

    return null ;
  }

  public static RTAction next(RTAction a)
  {
    if(a.getNext().size() > 0)
    {
      return a.getNext().get(0) ;
    }
    else
    {
      return null ;
    }
  }

}
