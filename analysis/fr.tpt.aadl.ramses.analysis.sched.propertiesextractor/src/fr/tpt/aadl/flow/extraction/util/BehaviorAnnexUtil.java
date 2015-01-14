/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.flow.extraction.util ;

import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.CommunicationAction ;
import org.osate.ba.aadlba.SubprogramCallAction ;


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

      for(AnnexSubclause annex : c.getOwnedAnnexSubclauses())
      {
        if(annex instanceof BehaviorAnnex)
        {
          return (BehaviorAnnex) annex ;
        }
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
    /*List<ParameterLabel> labels = a.getParameterLabels();
    if ((labels != null) && (!labels.isEmpty()))
    {
      try
      {
        ParameterLabel param = labels.get(0);
        ValueExpression ve = (ValueExpression) param;
        Relation rel = ve.getRelations().get(0);
        SimpleExpression se = rel.getSimpleExpressionOwned();
        Term t = se.getTerms().get(0);
        Factor f = t.getFactors().get(0);
        Name n = (Name) f.getValueOwned();
        Identifier id = n.getIdentifierOwned();
        DataAccess acc = (DataAccess) id.getAadlRef();
    
        //TODO: check if access name is equal to the resource name in process.
    
        return acc.getName();
      }
      catch (Exception e){THANK YOU FOR LOGGIN e.printStackTrace();}
    }*/
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