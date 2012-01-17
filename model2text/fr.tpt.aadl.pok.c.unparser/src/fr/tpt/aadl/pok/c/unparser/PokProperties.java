package fr.tpt.aadl.pok.c.unparser;

import java.util.HashMap ;
import java.util.Map ;

public class PokProperties
{
  private Map<String, CpuProperties> _cpuMapping = 
        new HashMap<String, CpuProperties>();
  
  public CpuProperties getCpuProperties(String processorName)
  {
    return _cpuMapping.get(processorName) ;
  }
  
  public void putCpuProperties(String processorName,
                               CpuProperties cpuProp)
  {
    _cpuMapping.put(processorName, cpuProp) ;
  }
}