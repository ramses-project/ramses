#include "arinc653/buffer.h"
#include "subprograms.h"
test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t the_proc_the_sender_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_buffer_refined_model__the_proc_the_sender_entrypoint_impl(BUFFER_ID_TYPE *  cnx_p_out)
{
  RETURN_CODE_TYPE test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret;
  common_pkg__Integer test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable;
  MESSAGE_SIZE_TYPE test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_Length = sizeof(common_pkg__Integer);
  SYSTEM_TIME_TYPE test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_TimeOut = 0;
  test_buffer_refined_model__the_proc_the_sender_behaviorIdentifier_enum whichPortActivated = test_buffer_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_sender_entrypoint_impl_current_state)
  {
    case test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_buffer_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      break;
    }
    case test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_buffer_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable);
      SEND_BUFFER ((*cnx_p_out), &test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable, test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_Length, test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_p_out_TimeOut, &test_buffer_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      break;
    }
  }
}
}
test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl(BUFFER_ID_TYPE *  p_in)
{
  RETURN_CODE_TYPE test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret;
  common_pkg__Integer test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable;
  MESSAGE_SIZE_TYPE test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_Length = sizeof(common_pkg__Integer);
  RETURN_CODE_TYPE test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode = 0;
  SYSTEM_TIME_TYPE test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_TimeOut = 0;
  test_buffer_refined_model__the_proc_the_receiver_behaviorIdentifier_enum whichPortActivated = test_buffer_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_receiver_entrypoint_impl_current_state)
  {
    case test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_buffer_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      break;
    }
    case test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_buffer_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      RECEIVE_BUFFER ((*p_in), test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_TimeOut, &test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable, &test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_Length, &test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode);
      if (test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode == 0) {
      receive (test_buffer_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable);
      }
      break;
    }
  }
}
}
