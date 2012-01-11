package fr.tpt.aadl.util.properties ;

import java.math.BigDecimal ;

public class FloatUtil
{

  public FloatUtil()
  {
  }

  public static float add(float... values)
  {
    BigDecimal res = new BigDecimal("0") ;

    for(float f : values)
    {
      BigDecimal bf = new BigDecimal(f + "") ;
      res = res.add(bf) ;
    }

    return res.floatValue() ;
  }

  public static float subtract(float left,
                               float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;
    return iLeft.subtract(iRight).floatValue() ;
  }

  public static float divide(float left,
                             float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;

    try
    {
      return iLeft.divide(iRight).floatValue() ;
    }
    catch(Exception e)
    {
      return iLeft.divide(iRight, BigDecimal.ROUND_HALF_DOWN).floatValue() ;
    }
  }

  public static int ceil_divide(float left,
                                float right)
  {
    float resF = divide(left, right) ;

    if(((int) resF) != resF)
    {
      return 1 + (int) resF ;
    }
    else
    {
      return (int) resF ;
    }
  }

  public static float multiply(float left,
                               float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;
    return iLeft.multiply(iRight).floatValue() ;
  }
}
