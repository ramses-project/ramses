#include "osek_runtime.h"

extern struct queue_type **QUEUES;

static void memcpy(char *dst, const char *src, unsigned int size)
{
  char *p = dst + size;
  while (dst != p) {
    *dst = *src;
    dst++;
    src++;
  }
}

StatusType SetOSEKEventData(EventQueueIdType queue_id, EventDataType value)
{
  StatusType status = E_OK;
  struct data_queue_type *q = (struct data_queue_type*) QUEUES[queue_id];
  status = GetResource(*(q->rez));
  if (status != E_OK)
    return status;

  if (q->used == q->queue_size) {
    status = E_OS_LIMIT;
  } else {
    q->used++;
    memcpy(&q->queue[q->last_idx++], value, q->type_size);
    q->last_idx = q->last_idx % q->queue_size;
    if (q->waiting)
      status = SetEvent(*(q->in_task), *(q->event));
  }
  ReleaseResource(*(q->rez));
  return status;
}

StatusType WaitOSEKEventData(EventQueueIdType queue_id, EventDataType dst)
{
  StatusType status = E_OK;
  struct data_queue_type *q = (struct data_queue_type*) QUEUES[queue_id];
  status = GetResource(*(q->rez));
  if (status != E_OK)
    return status;

  while (q->used == 0) {
    q->waiting = 1;
    ReleaseResource(*(q->rez));
    status = WaitEvent(*(q->event));
    if (status != E_OK)
      return status;
    status = GetResource(*(q->rez));
    if (status != E_OK)
      return status;
    ClearEvent(*(q->event));
    q->waiting = 0;
  }

  memcpy(dst, &q->queue[--q->last_idx], q->type_size);
  if (q->last_idx == -1)
    q->last_idx = q->queue_size - 1;
  q->used--;
  ReleaseResource(*(q->rez));
  return status;
}

StatusType SetOSEKEvent(EventQueueIdType queue_id)
{
  StatusType status = E_OK;
  struct event_queue_type *q = (struct event_queue_type*) QUEUES[queue_id];
  status = GetResource(*(q->rez));
  if (status != E_OK)
    return status;

  if (q->used == q->queue_size) {
    status = E_OS_LIMIT;
  } else {
    q->used++;
    if (q->waiting)
      status = SetEvent(*(q->in_task), *(q->event));
  }
  ReleaseResource(*(q->rez));
  return status;
}

StatusType WaitOSEKEvent(EventQueueIdType queue_id)
{
  StatusType status = E_OK;
  struct event_queue_type *q = (struct event_queue_type*) QUEUES[queue_id];
  status = GetResource(*(q->rez));
  if (status != E_OK)
    return status;

  while (q->used == 0) {
    q->waiting = 1;
    ReleaseResource(*(q->rez));
    status = WaitEvent(*(q->event));
    if (status != E_OK)
      return status;
    status = GetResource(*(q->rez));
    if (status != E_OK)
      return status;
    ClearEvent(*(q->event));
    q->waiting = 0;
  }

  q->used--;
  ReleaseResource(*(q->rez));
  return status;
}
