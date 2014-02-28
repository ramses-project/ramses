package fr.tpt.aadl.ramses.analysis.eg.util;

import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNodeKind ;

public class SharedResourceUtil
{
  private static final String[] GET_SUBPROGRAMS = {"Get_Resource", "Wait_Semaphore"};
  private static final String[] RELEASE_SUBPROGRAMS = {"Release_Resource", "Signal_Semaphore"};
  
  private SharedResourceUtil(){}
  
  public static boolean isGet_Resource (String name)
  {
    for(String _name : GET_SUBPROGRAMS)
    {
      if (name.equals(_name))
      {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isRelease_Resource (String name)
  {
    for(String _name : RELEASE_SUBPROGRAMS)
    {
      if (name.equals(_name))
      {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSynchronizationSubprogram (String name)
  {
    return isGet_Resource (name) || isRelease_Resource (name);
  }
  
  public static void setSynchronizationNode (EGNode n, String name)
  {
    if (isGet_Resource(name))
    {
      n.setKind(EGNodeKind.CriticalSectionStart);
    }
    else if (isRelease_Resource(name))
    {
      n.setKind(EGNodeKind.CriticalSectionEnd);
    }
  }
}
