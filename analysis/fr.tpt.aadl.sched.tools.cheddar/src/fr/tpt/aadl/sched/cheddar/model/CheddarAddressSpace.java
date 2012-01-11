package fr.tpt.aadl.sched.cheddar.model ;

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.List ;

import org.osate.aadl2.Element ;

public class CheddarAddressSpace extends CheddarElement
{

  private CheddarProcessor owner ;

  private List<CheddarResource> resources = new ArrayList<CheddarResource>() ;

  private int text_memory_size = 0 ;

  private int stack_memory_size = 0 ;

  private int data_memory_size = 0 ;

  private int heap_memory_size = 0 ;

  private int partition_index = -1 ;

  public CheddarAddressSpace(
                             Element aadlElement)
  {
    super(aadlElement) ;
  }

  /**
   * @return the owner
   */
  public CheddarProcessor getOwner()
  {
    return owner ;
  }

  /**
   * @param owner the owner to set
   */
  public void setOwner(CheddarProcessor owner)
  {
    this.owner = owner ;
  }

  /**
   * @return the text_memory_size
   */
  public int getText_memory_size()
  {
    return text_memory_size ;
  }

  /**
   * @param text_memory_size the text_memory_size to set
   */
  public void setText_memory_size(int text_memory_size)
  {
    this.text_memory_size = text_memory_size ;
  }

  /**
   * @return the stack_memory_size
   */
  public int getStack_memory_size()
  {
    return stack_memory_size ;
  }

  /**
   * @param stack_memory_size the stack_memory_size to set
   */
  public void setStack_memory_size(int stack_memory_size)
  {
    this.stack_memory_size = stack_memory_size ;
  }

  /**
   * @return the data_memory_size
   */
  public int getData_memory_size()
  {
    return data_memory_size ;
  }

  /**
   * @param data_memory_size the data_memory_size to set
   */
  public void setData_memory_size(int data_memory_size)
  {
    this.data_memory_size = data_memory_size ;
  }

  /**
   * @return the heap_memory_size
   */
  public int getHeap_memory_size()
  {
    return heap_memory_size ;
  }

  /**
   * @param heap_memory_size the heap_memory_size to set
   */
  public void setHeap_memory_size(int heap_memory_size)
  {
    this.heap_memory_size = heap_memory_size ;
  }

  public void setPartition_index(int partition_index)
  {
    this.partition_index = partition_index ;
  }

  public int getPartition_index()
  {
    return partition_index ;
  }

  public void addResource(CheddarResource r)
  {
    r.setOwner(this) ;
    resources.add(r) ;
  }

  public Collection<CheddarResource> getResources()
  {
    return resources ;
  }
}
