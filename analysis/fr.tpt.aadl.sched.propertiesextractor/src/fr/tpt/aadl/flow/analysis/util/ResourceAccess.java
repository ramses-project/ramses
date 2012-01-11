package fr.tpt.aadl.flow.analysis.util ;

public class ResourceAccess
{

  private float start = 0 ;
  private float end = 0 ;

  private String resourceID ;

  /**
   * @return the start
   */
  public float getStart()
  {
    return start ;
  }

  /**
   * @param start the start to set
   */
  void setStart(float start)
  {
    this.start = start ;
  }

  /**
   * @return the end
   */
  public float getEnd()
  {
    return end ;
  }

  /**
   * @param end the end to set
   */
  void setEnd(float end)
  {
    this.end = end ;
  }

  /**
   * @return the resourceID
   */
  public String getResourceID()
  {
    return resourceID ;
  }

  /**
   * @param resourceID the resourceID to set
   */
  void setResourceID(String resourceID)
  {
    this.resourceID = resourceID ;
  }
}
