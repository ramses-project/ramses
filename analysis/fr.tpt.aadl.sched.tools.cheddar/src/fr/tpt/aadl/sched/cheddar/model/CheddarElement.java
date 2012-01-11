package fr.tpt.aadl.sched.cheddar.model ;

import org.osate.aadl2.Element ;

public abstract class CheddarElement
{

  /** Element name. */
  private String name = null ;

  /** Corresponding AADL Element. */
  private final Element aadlElement ;

  /** Cheddar model. */
  protected CheddarModel model ;

  /**
   * Create a CheddarElement
   * @param aadlElement associated AADL element
   */
  public CheddarElement(
                        Element aadlElement)
  {
    this.aadlElement = aadlElement ;
  }

  protected void setModel(CheddarModel model)
  {
    this.model = model ;
  }

  public Element getAADLElement()
  {
    return aadlElement ;
  }

  public final void setName(String name)
  {
    this.name = name ;
  } ;

  public final String getName()
  {
    return name ;
  }

  public final CheddarModel getModel()
  {
    return model ;
  }

}
