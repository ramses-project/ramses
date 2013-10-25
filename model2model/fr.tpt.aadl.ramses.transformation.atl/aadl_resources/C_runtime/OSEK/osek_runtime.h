#ifndef OSEK_RUNTIME_H
#define OSEK_RUNTIME_H

#ifdef USE_TPL_OS 

#include "tpl_os_types.h"
#include "tpl_os_resource.h"
#include "tpl_os_event.h"

#else

#include "kernel.h"

#endif
/* Queue id type */
typedef int port_id_t;

/* Data type to send with events */
typedef void * data_t;

typedef struct port_queue_t {
  int queue_size;
  int first_idx;
  int last_idx;
  int write_idx;
  int msg_size;
  data_t * offset;
  char blocking;
} port_queue_t;

typedef struct thread_queue_t {
  int id;
  ResourceType * rez;
  TaskType *in_task;
  EventMaskType *event;
  char waiting;
  int msg_nb;
  port_queue_t ** port_queues;
} thread_queue_t;

typedef struct data_port_t {
  ResourceType * rez;
  void * data;
  int size;
} data_port_t;

StatusType SendOutput_runtime(thread_queue_t * global_q, int port_id, data_t value);

StatusType NextValue_runtime(thread_queue_t * global_q, int port_id, data_t dst);

StatusType GetValue_runtime(thread_queue_t * global_q, int port_id, data_t dst);

StatusType ReceiveInputs_runtime(thread_queue_t * global_q, int port_id);

StatusType GetValueDataPort_runtime(data_port_t * p, void* data);

StatusType PutValueDataPort_runtime(data_port_t * p, void* data);
#endif
