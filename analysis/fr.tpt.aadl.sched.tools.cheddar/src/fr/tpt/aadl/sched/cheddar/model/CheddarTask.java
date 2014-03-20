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
 
 package fr.tpt.aadl.sched.cheddar.model ;

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.List ;

import org.osate.aadl2.Element ;

import fr.tpt.aadl.sched.cheddar.strategies.ThreadSection.CheddarTaskType ;

public class CheddarTask extends CheddarElement
{
  private CheddarAddressSpace owner ;

  private CheddarTaskType type ;

  private String activationRule = null ;

  private float r_capacity = 1 ;
  private float r_start_time = 0 ;
  private float r_deadline = 0 ;
  private float r_blocking_time = 0 ;
  private float r_period = 0 ;
  private float r_jitter = 0 ;

  private String queueing_policy = "SCHED_FIFO" ;

  private int priority = 0 ;

  private int text_memory_size = 0 ;

  private int stack_memory_size = 0 ;

  private List<ResourceUse> uses = new ArrayList<ResourceUse>() ;

  public CheddarTask(Element aadlElement)
  {
    super(aadlElement) ;
  }

  void addUse(ResourceUse use)
  {
    uses.add(use) ;
  }

  public Collection<ResourceUse> getUses()
  {
    return uses ;
  }

  /**
   * @return the owner
   */
  public CheddarAddressSpace getOwner()
  {
    return owner ;
  }

  /**
   * @param owner the owner to set
   */
  public void setOwner(CheddarAddressSpace owner)
  {
    if(this.owner != null)
    {
      this.owner.getOwner().removeTask(this) ;
    }

    this.owner = owner ;
    this.owner.getOwner().addTask(this) ;
  }

  public void setType(CheddarTaskType type)
  {
    this.type = type ;
  }

  public CheddarTaskType getType()
  {
    return type ;
  }

  /**
   * @return the capacity
   */
  public int getCapacity()
  {
    int res = (int) Math.ceil(r_capacity / model.getScaling()) ;
    return res ;
  }

  /**
   * @param capacity the capacity to set
   */
  public void setCapacity(float capacity)
  {
    this.r_capacity = capacity ;
  }

  /**
   * @return the start_time
   */
  public int getStart_time()
  {
    return (int) Math.ceil(r_start_time / model.getScaling()) ;
  }

  /**
   * @param start_time the start_time to set
   */
  public void setStart_time(int start_time)
  {
    this.r_start_time = start_time ;
  }

  /**
   * @return the queueing_policy
   */
  public String getQueueing_policy()
  {
    return queueing_policy ;
  }

  /**
   * @param queueing_policy the queueing_policy to set
   */
  public void setQueueing_policy(String queueing_policy)
  {
    this.queueing_policy = queueing_policy ;
  }

  /**
   * @return the deadline
   */
  public int getDeadline()
  {
    return (int) Math.ceil(r_deadline / model.getScaling()) ;
  }

  /**
   * @param deadline the deadline to set
   */
  public void setDeadline(float deadline)
  {
    this.r_deadline = deadline ;
  }

  /**
   * @return the blocking_time
   */
  public int getBlocking_time()
  {
    return (int) Math.ceil(r_blocking_time / model.getScaling()) ;
  }

  /**
   * @param blocking_time the blocking_time to set
   */
  public void setBlocking_time(float blocking_time)
  {
    this.r_blocking_time = blocking_time ;
  }

  /**
   * @return the priority
   */
  public int getPriority()
  {
    return priority ;
  }

  /**
   * @param priority the priority to set
   */
  public void setPriority(int priority)
  {
    this.priority = priority ;
  }

  /**
   * @return the text_memory_size
   */
  public int getText_memory_size()
  {
    return text_memory_size ;
  }

  /**
   * @param text_memory_size the text_memory_size to set
   */
  public void setText_memory_size(int text_memory_size)
  {
    this.text_memory_size = text_memory_size ;
  }

  /**
   * @return the stack_memory_size
   */
  public int getStack_memory_size()
  {
    return stack_memory_size ;
  }

  /**
   * @param stack_memory_size the stack_memory_size to set
   */
  public void setStack_memory_size(int stack_memory_size)
  {
    this.stack_memory_size = stack_memory_size ;
  }

  /**
   * @return the period
   */
  public int getPeriod()
  {
    return (int) Math.ceil(r_period / model.getScaling()) ;
  }

  /**
   * @param period the period to set
   */
  public void setPeriod(float period)
  {
    this.r_period = period ;
  }

  /**
   * @return the jitter
   */
  public int getJitter()
  {
    return (int) Math.ceil(r_jitter / model.getScaling()) ;
  }

  /**
   * @param jitter the jitter to set
   */
  public void setJitter(float jitter)
  {
    this.r_jitter = jitter ;
  }

  public void setActivationRule(String activationRule)
  {
    this.activationRule = activationRule ;
  }

  public String getActivationRule()
  {
    return activationRule ;
  }
}