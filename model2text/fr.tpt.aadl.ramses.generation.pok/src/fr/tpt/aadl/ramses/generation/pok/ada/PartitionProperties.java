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

package fr.tpt.aadl.ramses.generation.pok.ada;

import java.util.LinkedHashSet;
import java.util.Set;

import fr.tpt.aadl.ramses.generation.pok.ada.AadlToConfADAUnparser.BlackBoardInfo;
import fr.tpt.aadl.ramses.generation.pok.ada.AadlToConfADAUnparser.QueueInfo;
import fr.tpt.aadl.ramses.generation.pok.ada.AadlToConfADAUnparser.SampleInfo;


public class PartitionProperties
{
  public boolean hasBlackboard = false ; 
  
  public boolean hasQueue = false ;
  
  public boolean hasBuffer = false ;
  
  public boolean hasEvent = false ;
  
  public boolean hasSample = false ;
  
  public boolean hasSemaphore = false ;
  
  public Set<BlackBoardInfo> blackboardInfo = new LinkedHashSet<BlackBoardInfo>() ;
  
  public Set<String> eventNames = new LinkedHashSet<String>() ;
  
  public Set<QueueInfo> bufferInfo = new LinkedHashSet<QueueInfo>() ;
  
  public Set<QueueInfo> queueInfo = new LinkedHashSet<QueueInfo>();
  
  public Set<SampleInfo> sampleInfo = new LinkedHashSet<SampleInfo>();
  
  public Set<String> semaphoreNames = new LinkedHashSet<String>() ;
}