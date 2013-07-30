#ifndef OSEK_RUNTIME_H
#define OSEK_RUNTIME_H
#include "tpl_os_types.h"
#include "tpl_os_resource.h"
#include "tpl_os_event.h"

/* Queue id type */
typedef int port_id_t;

/* Data type to send with events */
typedef char * data_t;

typedef struct port_queue_t {
  int queue_size;
  int first_idx;
  int last_idx;
  int write_idx;
  int msg_size;
  data_t * offset;
} port_queue_t;

typedef struct thread_queue_t {
  int id;
  ResourceType *rez;
  TaskType *in_task;
  EventMaskType *event;
  char waiting;
  int msg_nb;
  port_queue_t ** port_queues;
} thread_queue_t;


/*  Send an event with a data */
StatusType SetOSEKEventData(thread_queue_t * global_q, int port_id, data_t value);

/* Wait for an event-data */
StatusType WaitOSEKEventData(port_id_t port_id, data_t dst);

/* Send an event */
StatusType SetOSEKEvent(thread_queue_t * global_q, port_id_t queue_id);

/* Wait for an event */
StatusType WaitOSEKEvent(port_id_t port_id);

#endif
