package fr.tpt.aadl.ramses.analysis.eg.util;

public class DoubleRange
{

  private final double min ;
  private final double max ;

  public DoubleRange(double min, double max)
  {
    this.min = min;
    this.max = max;
  }

  public double getMin()
  {
    return min ;
  }

  public double getMax()
  {
    return max ;
  }

}
