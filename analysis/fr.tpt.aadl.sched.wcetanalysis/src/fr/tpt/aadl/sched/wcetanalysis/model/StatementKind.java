package fr.tpt.aadl.sched.wcetanalysis.model ;

public enum StatementKind
{

  Empty,

  ReadPort,

  WritePort,

  GetResource,

  ReleaseResource,

  Compute,

  GenericCall,

  Assignment,

  Conditional,

  ConditionalEnd,

  AwaitDispatch,

  Loop,

  LoopEnd,
  
  ASTStartOrEnd
}
