package fr.tpt.aadl.util.properties ;

public class IntegerRange
{

  private final int min, max ;

  public IntegerRange(
                      int min, int max)
  {
    this.min = min ;
    this.max = max ;
  }

  public int getMin()
  {
    return min ;
  }

  public int getMax()
  {
    return max ;
  }

  public int length()
  {
    return max - min ;
  }
}
