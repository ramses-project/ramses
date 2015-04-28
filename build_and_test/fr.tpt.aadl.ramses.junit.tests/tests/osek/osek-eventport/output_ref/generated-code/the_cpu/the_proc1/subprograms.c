#include "osek_runtime.h"
#include "subprograms.h"
test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_State_t the_proc1_the_sender_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl(
	thread_queue_t *  cnx_p)
{
  StatusType test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_the_proc1_the_sender_runtime_call_ret;
  Base_Types__Integer_16 test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_p_localVariable;
  __sender_spg_context test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_c_context = {0};
  test_osek_eventports_refined_model__the_proc1_the_sender_behaviorIdentifier_enum whichPortActivated = test_osek_eventports_refined_model__the_proc1_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc1_the_sender_entrypoint_impl_current_state)
  {
    case test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc1_the_sender_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_eventports_refined_model__the_proc1_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc1_the_sender_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_eventports_refined_model__the_proc1_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc1_the_sender_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_osek_eventports_refined_model__the_proc1_the_sender_entrypoint_impl_c_context);
      break;
    }
  }
}
}
test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_State_t the_proc1_the_receiver_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl(
	thread_queue_t *  p)
{
  StatusType test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_the_proc1_the_receiver_runtime_call_ret;
  Base_Types__Integer_16 test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_p_localVariable;
  StatusType test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_p_ErrorCode = 0;
  test_osek_eventports_refined_model__the_proc1_the_receiver_behaviorIdentifier_enum whichPortActivated = test_osek_eventports_refined_model__the_proc1_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc1_the_receiver_entrypoint_impl_current_state)
  {
    case test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc1_the_receiver_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_eventports_refined_model__the_proc1_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc1_the_receiver_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_eventports_refined_model__the_proc1_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc1_the_receiver_entrypoint_impl_current_state = test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_eventports_refined_model__the_proc1_the_receiver_entrypoint_impl_p_ErrorCode = ReceiveInputs_runtime (p, 0);
      receive ();
      break;
    }
  }
}
}
