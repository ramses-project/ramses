#include "activity.h"
#include "main.h"

extern BLACKBOARD_ID_TYPE the_receiver_p_in_globalVariable;
test_blackboard_refined_model__the_proc_the_sender_impl_BA_State_t the_proc_the_sender_impl_current_state = test_blackboard_refined_model__the_proc_the_sender_impl_main_state;
void* test_blackboard_refined_model__the_proc_the_sender_impl_Job()
{
  while(1)
{
  switch(the_proc_the_sender_impl_current_state)
  {
    case test_blackboard_refined_model__the_proc_the_sender_impl_main_state:
    // Transition id: dispatch_transition
    if(1)
    {
      the_proc_the_sender_impl_current_state = test_blackboard_refined_model__the_proc_the_sender_impl_main_state;
      if (1) {
      test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_in_globalVariable);
      }
      return;
    }
  }
}
return 0;
}
extern BLACKBOARD_ID_TYPE the_receiver_p_in_globalVariable;
test_blackboard_refined_model__the_proc_the_receiver_impl_BA_State_t the_proc_the_receiver_impl_current_state = test_blackboard_refined_model__the_proc_the_receiver_impl_main_state;
void* test_blackboard_refined_model__the_proc_the_receiver_impl_Job()
{
  while(1)
{
  switch(the_proc_the_receiver_impl_current_state)
  {
    case test_blackboard_refined_model__the_proc_the_receiver_impl_main_state:
    // Transition id: dispatch_transition
    if(1)
    {
      the_proc_the_receiver_impl_current_state = test_blackboard_refined_model__the_proc_the_receiver_impl_main_state;
      if (1) {
      test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_in_globalVariable);
      }
      return;
    }
  }
}
return 0;
}
