package fr.tpt.aadl.sched.wcetanalysis.util ;

import java.util.ArrayList;
import java.util.List;

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
  
  public static List<ASTNode> getAll(StatementKind sequenceType, ASTNode start)
  {
	List<ASTNode> list = new ArrayList<ASTNode>();
	ASTNode current = start ;

	while(current != null)
	{
	  if(current.getType() == sequenceType)
	  {
	    list.add(current);
	  }

	  current = next(current) ;
	}

    return list ;
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

  public static List<ASTNode> getSubsequence(ASTNode first, ASTNode last) 
  {
	 List<ASTNode> seq = new ArrayList<ASTNode>();
	 ASTNode next = first;
	 do
	 {
		 seq.add(next);
		 next = next(next);
	 }
	 while (next != last);
	 
	 seq.add(last);
	 
	 return seq;
  }

}
