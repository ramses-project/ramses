package fr.tpt.aadl.sched.wcetanalysis.util ;

import java.util.List;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.CommunicationAction;
import org.osate.ba.aadlba.DataAccessHolder;
import org.osate.ba.aadlba.ParameterLabel;
import org.osate.ba.aadlba.SubprogramCallAction;


public class BehaviorAnnexUtil
{

  private BehaviorAnnexUtil()
  {
  }

  public static BehaviorAnnex getBehaviorAnnex(NamedElement e)
  {
    if(e instanceof ComponentInstance)
    {
      return getBehaviorAnnex(((ComponentInstance) e).getSubcomponent()) ;
    }
    else if(e instanceof Subcomponent)
    {
      return getBehaviorAnnex(((Subcomponent) e).getClassifier()) ;
    }
    else if(e instanceof Classifier)
    {
      Classifier c = (Classifier) e ;
      
      while (c != null)
      {
    	  for(AnnexSubclause annex : c.getOwnedAnnexSubclauses())
          {
            if(annex instanceof BehaviorAnnex)
            {
              return (BehaviorAnnex) annex ;
            }
          }
    	  
    	  c = c.getExtended();
      }
      
      return null ;
    }
    else
    {
      return null ;
    }
  }

  public static NamedElement getSubprogramReference(CommunicationAction a)
  {
    SubprogramCallAction c = (SubprogramCallAction) a ;
    return c.getSubprogram().getElement() ;
  }
  
  public static String getSharedDataNameFromSubprogramCall(SubprogramCallAction a)
  {
    List<ParameterLabel> labels = a.getParameterLabels();
    if ((labels != null) && (!labels.isEmpty()))
    {
      try
      {
        ParameterLabel param = labels.get(0);
        DataAccessHolder h = (DataAccessHolder) param;
        return h.getDataAccess().getName();
      }
      catch (Exception e){e.printStackTrace();}
    }
    return null ;
  }

  public static String getInitialState(BehaviorAnnex ba)
  {
    for(BehaviorState s : ba.getStates())
    {
      if(s.isInitial())
      {
        return s.getName() ;
      }
    }

    return null ;
  }

  public static String getFinalState(BehaviorAnnex ba)
  {
    for(BehaviorState s : ba.getStates())
    {
      if(s.isFinal())
      {
        return s.getName() ;
      }
    }

    return null ;
  }
}
