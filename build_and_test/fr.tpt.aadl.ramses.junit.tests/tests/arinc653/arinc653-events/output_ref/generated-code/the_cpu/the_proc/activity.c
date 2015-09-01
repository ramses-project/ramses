#include "activity.h"
#include "main.h"

extern BUFFER_ID_TYPE the_receiver_p_in_globalVariable;
extern EVENT_ID_TYPE the_proc_the_receiver_barrier;
void* test_events_refined_model__the_proc_the_sender_impl_Job()
{
  test_events_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_in_globalVariable, &the_proc_the_receiver_barrier);
  return 0;
}
extern BUFFER_ID_TYPE the_receiver_p_in_globalVariable;
extern EVENT_ID_TYPE the_proc_the_receiver_barrier;
void* test_events_refined_model__the_proc_the_receiver_impl_Job()
{
  test_events_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_in_globalVariable, &the_proc_the_receiver_barrier);
  return 0;
}
