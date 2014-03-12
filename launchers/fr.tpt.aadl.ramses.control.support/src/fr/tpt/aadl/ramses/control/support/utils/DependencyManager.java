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

package fr.tpt.aadl.ramses.control.support.utils;

import java.util.HashSet ;
import java.util.LinkedHashMap ;
import java.util.LinkedHashSet ;
import java.util.Map ;
import java.util.Set ;

public class DependencyManager<T, V>
{
  protected Set<V> _CommonDependencies = new LinkedHashSet<V>();
  
  protected Map<T, Set<V>> _dependenciesMap = 
                                        new LinkedHashMap<T,Set<V>>();
  
  public Set<V> getCommonDependencies()
  {
    return _CommonDependencies ;
  }
  
  public void addCommonDependency(V dependency)
  {
    _CommonDependencies.add(dependency) ;
  }
  
  public void setCommonDependency(Set<V> dependencies)
  {
    _CommonDependencies = dependencies ;
  }
  
  public boolean addDependency(T node , V dependency)
  {
    boolean result = false ;
    
    if(_dependenciesMap.containsKey(node))
    {
      result = _dependenciesMap.get(node).add(dependency) ;
    }
    else
    {
      Set<V> tmp = new HashSet<V>() ;
      tmp.add(dependency) ;
      _dependenciesMap.put(node, tmp) ;
      result = true ;
    }
    
    return result ;
  }
  
  public boolean addDependencies(T node, Set<V> dependencies)
  {
    boolean result = false ;
    
    if(_dependenciesMap.containsKey(node))
    {
      result = _dependenciesMap.get(node).addAll(dependencies) ;
    }
    else
    {
      _dependenciesMap.put(node, dependencies) ;
      result = true ;
    }
    
    return result ;
  }
  
  public Set<V> getDenpendencies(T node)
  {
    Set<V> result = null ;
    
    if(_dependenciesMap.containsKey(node))
    {
      result = _dependenciesMap.get(node) ;
    }
    else
    {
      result = null ;
    }
    
    return result ;
  }
}