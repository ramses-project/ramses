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

package fr.tpt.aadl.ramses.control.cli.instantiation ;

import java.util.ArrayList ;
import java.util.List ;

public class AnnexJobHandler
{
  private List<AnnexJob> _jobList = new ArrayList<AnnexJob>() ;

  public void addJob(AnnexJob job)
  {
    _jobList.add(job) ;
  }

  public boolean parseAllAnnexes()
  {
    boolean result = true ;

    for(AnnexJob job : _jobList)
    {
      result &= job.parse() ;
    }

    return result ;
  }

  public boolean resolveAllAnnexes()
  {
    boolean result = true ;

    for(AnnexJob job : _jobList)
    {
      result &= job.resolve() ;
    }
    
    _jobList.clear() ;
    
    return result ;
  }
}