#include "arinc653/buffer.h"
#include "arinc653/event.h"
#include "subprograms.h"
test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t the_proc_the_sender_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_events_refined_model__the_proc_the_sender_entrypoint_impl(
	BUFFER_ID_TYPE *  cnx_p_out,
	EVENT_ID_TYPE *  cnx_p_out_entrypoint_barrier)
{
  RETURN_CODE_TYPE test_events_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret;
  Base_Types__Integer_16 test_events_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable;
  __event_sender_spg_context test_events_refined_model__the_proc_the_sender_entrypoint_impl_c_context = {0};
  test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum whichPortActivated = test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_sender_entrypoint_impl_current_state)
  {
    case test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_events_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      break;
    }
    case test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send_event (&test_events_refined_model__the_proc_the_sender_entrypoint_impl_c_context);
      break;
    }
  }
}
}
test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t the_proc_the_receiver_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_events_refined_model__the_proc_the_receiver_entrypoint_impl(
	BUFFER_ID_TYPE *  p_in,
	EVENT_ID_TYPE *  the_receiver_PortIdAccess_barrier)
{
  RETURN_CODE_TYPE test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret;
  Base_Types__Integer_16 test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable;
  MESSAGE_SIZE_TYPE test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_Length = sizeof(Base_Types__Integer_16);
  RETURN_CODE_TYPE test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode = 0;
  SYSTEM_TIME_TYPE test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_TimeOut = 0;
  SYSTEM_TIME_TYPE test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_receiver_TimeOut = 200;
  MESSAGE_RANGE_TYPE p_in_call_message_count;
BUFFER_STATUS_TYPE p_in_call_status;
test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum whichPortActivated = test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_receiver_entrypoint_impl_current_state)
  {
    case test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      WAIT_EVENT ((*the_receiver_PortIdAccess_barrier), test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_receiver_TimeOut, &test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      RESET_EVENT ((*the_receiver_PortIdAccess_barrier), &test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      GET_BUFFER_STATUS ((*p_in), &p_in_call_status, &test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      p_in_call_message_count = p_in_call_status.NB_MESSAGE;
      if (p_in_call_message_count != 0) {
      whichPortActivated = test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_p_in;
      RECEIVE_BUFFER ((*p_in), test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_TimeOut, &test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable, &test_events_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_Length, &test_events_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      }
      else {
      whichPortActivated = test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      }
      break;
    }
    case test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 1
    if(whichPortActivated == test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_p_in)
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      event_received ();
      break;
    }
    // Transition id: call_nothing -- Priority 0
    if(whichPortActivated == test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      nothing_received ();
      break;
    }
  }
}
}
