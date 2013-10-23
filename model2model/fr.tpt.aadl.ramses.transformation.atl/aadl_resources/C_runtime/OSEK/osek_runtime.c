#include "osek_runtime.h"

static void memcpy(char *dst, const char *src, unsigned int size)
{
  char *p = dst + size;
  while (dst != p) {
    *dst = *src;
    dst++;
    src++;
  }
}

StatusType PutEventMessage(thread_queue_t * global_q, port_id_t port_id)
{
  StatusType status = E_OK;
  struct port_queue_t *port_q = (struct port_queue_t*) global_q->port_queues[port_id];
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;

  if (port_q->write_idx == port_q->first_idx) {
    status = E_OS_LIMIT;
  } else {
    global_q->msg_nb++;
    port_q->write_idx = (port_q->write_idx+1) % port_q->queue_size;
    if (global_q->waiting)
      status = SetEvent(*(global_q->in_task), *(global_q->event));
  }
  ReleaseResource(*(global_q->rez));
  return status;
}

StatusType PutValue(thread_queue_t * global_q, int port_id, data_t value)
{
  StatusType status = E_OK;
  struct port_queue_t *port_q = (struct port_queue_t*) global_q->port_queues[port_id];
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;

  if (port_q->write_idx == port_q->first_idx) {
    status = E_OS_LIMIT;
  } else {
    global_q->msg_nb++;
    port_q->write_idx = (port_q->write_idx+1) % port_q->queue_size;
    memcpy(port_q->offset[port_q->write_idx], value, port_q->msg_size);
  }
  

  ReleaseResource(*(global_q->rez));
  return status;
}

StatusType SendOutput(thread_queue_t * global_q, int port_id, data_t value)
{
  StatusType status = E_OK;
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;

  if (global_q->waiting)
      status = SetEvent(*(global_q->in_task), *(global_q->event));


  ReleaseResource(*(global_q->rez));
  return status;
}

StatusType NextValue(thread_queue_t * global_q, int port_id, data_t dst)
{
  StatusType status = E_OK;
  struct port_queue_t *port_q = (struct port_queue_t*) global_q->port_queues[port_id];
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;

  if(port_q->first_idx < port_q->last_idx)
    port_q->first_idx++;

  *dst = *(port_q->offset[port_q->first_idx]);
  global_q->msg_nb--;

  ReleaseResource(*(global_q->rez));
  return status;
}

StatusType GetValue(thread_queue_t * global_q, int port_id, data_t dst)
{
  StatusType status = E_OK;
  struct port_queue_t *port_q = (struct port_queue_t*) global_q->port_queues[port_id];
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;

  *dst = *(port_q->offset[port_q->first_idx]);

  ReleaseResource(*(global_q->rez));
  return status;
}


StatusType ReceiveInputs(thread_queue_t * global_q, int port_id)
{
  StatusType status = E_OK;
  struct port_queue_t * port_q = (struct port_queue_t*) global_q->port_queues[port_id];
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;
  if(port_q->last_idx == port_q->first_idx)
    status = E_OS_LIMIT;
  else if(port_q->last_idx == port_q->write_idx-1)
    status = E_OS_LIMIT;
  if(status == E_OK)
  {
    int discarded_msg_nb = port_q->last_idx-port_q->first_idx;
    port_q->first_idx=port_q->last_idx;
    port_q->last_idx = port_q->write_idx-1;
    global_q->msg_nb-=discarded_msg_nb;
  }
  ReleaseResource(*(global_q->rez));
  return status; 
}

StatusType GetEventMessage(thread_queue_t * global_q)
{
  StatusType status = E_OK;
  status = GetResource(*(global_q->rez));
  if (status != E_OK)
    return status;

  while (global_q->msg_nb == 0) {
    global_q->waiting = 1;
    ReleaseResource(*(global_q->rez));
    status = WaitEvent(*(global_q->event));
    if (status != E_OK)
      return status;
    status = GetResource(*(global_q->rez));
    if (status != E_OK)
      return status;
    ClearEvent(*(global_q->event));
    global_q->waiting = 0;
  }
  
  ReleaseResource(*(global_q->rez));
  return status;
}

StatusType GetValueDataPort(data_port_t * p, void* data)
{
  StatusType status = E_OK;
  status = GetResource(*(p->rez));
  memcpy (data, p->data, p->size);
  status = GetResource(*(p->rez));
  return status;
}

StatusType PutValueDataPort(data_port_t * p, void* data)
{
  StatusType status = E_OK;
  status = GetResource(*(p->rez));
  if(status != E_OK)
    return status;
  memcpy (p->data, data, p->size);
  status = GetResource(*(p->rez));
  return status;
}
