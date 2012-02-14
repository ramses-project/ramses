package fr.tpt.aadl.sched.cheddar.model ;

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.List ;

import org.osate.aadl2.Element ;

public class CheddarResource extends CheddarElement
{

  private CheddarAddressSpace owner ;

  private String protocol = "" ;

  private List<ResourceUse> uses = new ArrayList<ResourceUse>() ;

  public CheddarResource(
                         Element aadlElement)
  {
    super(aadlElement) ;
  }

  public void addUse(CheddarTask user,
                     float wait,
                     float release)
  {
    uses.add(new ResourceUse(user, this, wait, release)) ;
  }

  public Collection<ResourceUse> getUses()
  {
    return uses ;
  }

  /**
   * @return the address_space
   */
  public CheddarAddressSpace getOwner()
  {
    return owner ;
  }

  /**
   * @param address_space the address_space to set
   */
  public void setOwner(CheddarAddressSpace address_space)
  {
    this.owner = address_space ;
  }

  /**
   * @return the protocol
   */
  public String getProtocol()
  {
    return protocol ;
  }

  /**
   * @param protocol the protocol to set
   */
  public void setProtocol(String protocol)
  {
    this.protocol = protocol ;
  }
}
