package fr.tpt.aadl.util.properties ;

public class UnitConversion
{

  public static float convertInMs(float value,
                                  String sourceUnit)
  {
    if(sourceUnit.equals("hr"))
    {
      float min = FloatUtil.multiply(value, 60) ;
      return convertInMs(min, "min") ;
    }

    if(sourceUnit.equals("min"))
    {
      float sec = FloatUtil.multiply(value, 60) ;
      return convertInMs(sec, "sec") ;
    }

    if(sourceUnit.equals("sec"))
    {
      float ms = FloatUtil.multiply(value, 1000) ;
      return ms ;
    }

    if(sourceUnit.equals("ms"))
    {
      return value ;
    }

    if(sourceUnit.equals("us"))
    {
      float ms = FloatUtil.divide(value, 1000) ;
      return ms ;
    }

    if(sourceUnit.equals("ns"))
    {
      float us = FloatUtil.divide(value, 1000) ;
      return convertInMs(us, "us") ;
    }

    if(sourceUnit.equals("ps"))
    {
      float ns = FloatUtil.divide(value, 1000) ;
      return convertInMs(ns, "ns") ;
    }

    return value ;
  }

}
