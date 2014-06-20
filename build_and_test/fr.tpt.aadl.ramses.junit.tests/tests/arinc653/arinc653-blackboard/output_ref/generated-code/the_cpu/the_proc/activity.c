#include "activity.h"
#include "main.h"

extern BLACKBOARD_ID_TYPE the_receiver_p_in_globalVariable;
void* test_blackboard_refined_model__the_proc_the_sender_impl_Job()
{
  while (1) {
    test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_in_globalVariable);
  }
  return 0;
}
extern BLACKBOARD_ID_TYPE the_receiver_p_in_globalVariable;
void* test_blackboard_refined_model__the_proc_the_receiver_impl_Job()
{
  while (1) {
    test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_in_globalVariable);
  }
  return 0;
}
