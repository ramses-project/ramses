#include "activity.h"
#include "main.h"

extern test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl the_receiver_p_in_Buffer;
test_buffer_delayed_refined_model__the_proc_the_sender_impl_BA_State_t the_proc_the_sender_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_sender_impl_main_state;
void* test_buffer_delayed_refined_model__the_proc_the_sender_impl_Job()
{
  while(1)
{
  switch(the_proc_the_sender_impl_current_state)
  {
    case test_buffer_delayed_refined_model__the_proc_the_sender_impl_main_state:
    // Transition id: dispatch_transition
    if(1)
    {
      the_proc_the_sender_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_sender_impl_main_state;
      if (1) {
      test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_in_Buffer);
      }
      return;
    }
  }
}
return 0;
}
extern test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl the_receiver_p_in_Buffer;
test_buffer_delayed_refined_model__the_proc_the_receiver_impl_BA_State_t the_proc_the_receiver_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_receiver_impl_main_state;
void* test_buffer_delayed_refined_model__the_proc_the_receiver_impl_Job()
{
  while(1)
{
  switch(the_proc_the_receiver_impl_current_state)
  {
    case test_buffer_delayed_refined_model__the_proc_the_receiver_impl_main_state:
    // Transition id: dispatch_transition
    if(1)
    {
      the_proc_the_receiver_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_receiver_impl_main_state;
      if (1) {
      test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_in_Buffer);
      }
      return;
    }
  }
}
return 0;
}
