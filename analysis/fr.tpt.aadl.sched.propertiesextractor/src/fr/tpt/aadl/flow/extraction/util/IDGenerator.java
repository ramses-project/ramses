package fr.tpt.aadl.flow.extraction.util ;

import java.util.HashMap ;
import java.util.Map ;

public class IDGenerator
{

  private static Map<String, Integer> nameOccurrences =
        new HashMap<String, Integer>() ;

  public static String getNewIdForName(String name)
  {
    Integer countO = nameOccurrences.get(name) ;
    int count = 1 ;

    if(countO != null)
    {
      count = countO.intValue() + 1 ;
    }

    nameOccurrences.put(name, count) ;
    return name + "__" + count ;
  }

}
