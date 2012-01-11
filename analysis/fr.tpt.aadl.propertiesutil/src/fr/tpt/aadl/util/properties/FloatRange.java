package fr.tpt.aadl.util.properties ;

public class FloatRange
{

  public final static FloatRange nullValue = new FloatRange(0f, 0f) ;

  private final float min, max ;

  public FloatRange(
                    float min, float max)
  {
    this.min = min ;
    this.max = max ;
  }

  public FloatRange(
                    float value)
  {
    this(value, value) ;
  }

  public float getMin()
  {
    return min ;
  }

  public float getMax()
  {
    return max ;
  }
}
