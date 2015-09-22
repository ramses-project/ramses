#include "activity.h"
#include "main.h"

extern thread_queue_t the_receiver_globalQueue;
void* test_osek_eventports_refined_model__the_proc1_the_sender_impl_Job()
{
  test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl (&the_receiver_globalQueue);
  return 0;
}
extern thread_queue_t the_receiver_globalQueue;
void* test_osek_eventports_refined_model__the_proc1_the_receiver_impl_Job()
{
  test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl (&the_receiver_globalQueue);
  return 0;
}
