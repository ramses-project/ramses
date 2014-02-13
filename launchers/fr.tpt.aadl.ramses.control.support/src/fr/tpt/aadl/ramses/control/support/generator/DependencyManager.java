package fr.tpt.aadl.ramses.control.support.generator;

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