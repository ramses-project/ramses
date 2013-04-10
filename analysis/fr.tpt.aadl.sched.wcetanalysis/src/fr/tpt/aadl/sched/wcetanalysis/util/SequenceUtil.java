package fr.tpt.aadl.sched.wcetanalysis.util ;

import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;

public class SequenceUtil
{

  private SequenceUtil()
  {
  }

  public static ASTNode getFirstAfterSequenceOf(StatementKind sequenceType,
                                                 ASTNode start)
  {
    ASTNode current = start ;

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

  public static ASTNode getFirstOf(StatementKind sequenceType,
                                    ASTNode start)
  {
    ASTNode current = start ;

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

  public static ASTNode next(ASTNode a)
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
