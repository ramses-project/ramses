#ifndef OSEK_RUNTIME_H
#define OSEK_RUNTIME_H
#include "tpl_os_types.h"
#include "tpl_os_rez.h"
#include "tpl_os_event.h"

/* Queue id type */
typedef int EventQueueIdType;

/* Data type to send with events */
typedef void * EventDataType;


struct queue_type {
  int id;
  ResourceType *rez;
  TaskType *in_task;
  EventMaskType *event;
  int waiting;
  int queue_size;
  int used;
};

struct data_queue_type {
  int id;
  const ResourceType *rez;
  const TaskType *in_task;
  const EventMaskType *event;
  int waiting;
  int queue_size;
  int used;
  int type_size;
  int last_idx;
  char queue[1];
};

struct event_queue_type {
  int id;
  const ResourceType *rez;
  const TaskType *in_task;
  const EventMaskType *event;
  int waiting;
  int queue_size;
  int used;
};

#define EVENT_DATA_QUEUE(TYPE, IN_TASK, SIZE, ID)\
DeclareResource(QUEUE_ ## ID ## _rez);\
DeclareEvent(QUEUE_ ## ID ## _evt);\
struct {\
  int id;\
  const ResourceType *rez;\
  const TaskType *in_task;\
  const EventMaskType *event;\
  int waiting;\
  int queue_size;\
  int used;\
  int type_size;\
  int last_idx;\
  TYPE queue[SIZE];\
} QUEUE_ ## ID = {ID, &QUEUE_ ## ID ## _rez, &IN_TASK, &QUEUE_ ## ID ## _evt, 0, SIZE, 0, sizeof(TYPE), 0};

#define EVENT_QUEUE(IN_TASK, SIZE, ID)\
DeclareResource(QUEUE_ ## ID ## _rez);\
DeclareEvent(QUEUE_ ## ID ## _evt);\
struct event_queue_type QUEUE_ ## ID = {ID, &QUEUE_ ## ID ## _rez, &IN_TASK, &QUEUE_ ## ID ## _evt, 0, SIZE, 0};


/* Queue initialization example */
/*EVENT_DATA_QUEUE(int, Task1, 10, 0);
EVENT_DATA_QUEUE(short, Task2, 15, 1);
EVENT_QUEUE(Task1, 1, 2);

struct queue_type* QUEUES[3] = {(struct queue_type *)&QUEUE_0, 
                                (struct queue_type *)&QUEUE_1, 
                                (struct queue_type *)&QUEUE_2};
*/

/*  Send an event with a data */
StatusType SetOSEKEventData(EventQueueIdType queue_id, EventDataType value);

/* Wait for an event-data */
StatusType WaitOSEKEventData(EventQueueIdType queue_id, EventDataType dst);

/* Send an event */
StatusType SetOSEKEvent(EventQueueIdType queue_id);

/* Wait for an event */
StatusType WaitOSEKEvent(EventQueueIdType queue_id);
#endif
