/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.generation.c ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.Comment ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch ;

public class AadlToCSwitchProcess
{

  private static AadlProcessingSwitch aadlSwitch ;

  private static void setAadlSwitch(AadlProcessingSwitch s)
  {
    aadlSwitch = s ;
  }

  private UnparseText unparserContent ;

  public AadlToCSwitchProcess(AadlProcessingSwitch s)
  {
    unparserContent = new UnparseText() ;
    setAadlSwitch(s) ;
  }

  public void addOutput(String more)
  {
    unparserContent.addOutput(more) ;
  }

  public void addOutputNewline(String more)
  {
    unparserContent.addOutputNewline(more) ;
  }

  public void processComments(final Element obj)
  {
    if(obj != null)
    {
      EList<Comment> el = obj.getOwnedComments() ;

      for(Comment comment : el)
      {
        String str = comment.getBody() ;

        if(!str.startsWith("--"))
        {
          str = "// " + str.substring(2) ;
        }

        unparserContent.addOutputNewline(str) ;
      }
    }
  }

  public static void process(Element elt)
  {
    aadlSwitch.process(elt) ;
  }

  public String getIndent()
  {
    return unparserContent.getIndentString() ;
  }

  public String getOutput()
  {
    return unparserContent.getParseOutput() ;
  }

  public void incrementIndent()
  {
    unparserContent.incrementIndent() ;
  }

  public void decrementIndent()
  {
    unparserContent.decrementIndent() ;
  }
}