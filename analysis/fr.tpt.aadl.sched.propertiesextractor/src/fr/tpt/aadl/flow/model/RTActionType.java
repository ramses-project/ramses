package fr.tpt.aadl.flow.model ;

public enum RTActionType
{

  Empty,

  ReadPort,

  WritePort,

  WaitResource,

  ReleaseResource,

  Compute,

  GenericCall,

  Assignment,

  Conditional,

  ConditionalEnd,

  WaitTaskNextActivation,

  Loop,

  LoopEnd
}
