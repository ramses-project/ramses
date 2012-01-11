package fr.tpt.aadl.sched.cheddar.model ;

public class ResourceUse
{

  private CheddarTask user ;

  private float waitDate ;

  private float releaseDate ;

  private CheddarResource r ;

  ResourceUse(
              CheddarTask user, CheddarResource r, float wait, float release)
  {
    this.user = user ;
    this.waitDate = wait ;
    this.releaseDate = release ;
    this.r = r ;
    user.addUse(this) ;
  }

  public CheddarResource getResource()
  {
    return r ;
  }

  /**
   * @return the user
   */
  public CheddarTask getUser()
  {
    return user ;
  }

  /**
   * @return the waitDate
   */
  public float getWaitDate()
  {
    return waitDate ;
  }

  /**
   * @return the releaseDate
   */
  public float getReleaseDate()
  {
    return releaseDate ;
  }

}
