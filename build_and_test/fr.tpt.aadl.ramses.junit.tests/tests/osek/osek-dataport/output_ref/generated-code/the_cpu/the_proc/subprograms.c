#include "osek_runtime.h"
#include "subprograms.h"
test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t the_proc_the_sender_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl(
	data_port_t *  cnx_p)
{
  StatusType test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret;
  test_osek_dataports__Integer test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_p_localVariable;
  Base_Types__Integer_16 test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_p_Length = sizeof(test_osek_dataports__Integer);
  test_osek_dataports_refined_model__the_proc_the_sender_behaviorIdentifier_enum whichPortActivated = test_osek_dataports_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_sender_entrypoint_impl_current_state)
  {
    case test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_dataports_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_dataports_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_p_localVariable);
      test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret = PutValueDataPort_runtime (cnx_p, &test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl_p_localVariable);
      break;
    }
  }
}
}
test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t the_proc_the_receiver_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl(
	data_port_t *  p)
{
  StatusType test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret;
  test_osek_dataports__Integer test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_localVariable;
  Base_Types__Integer_16 test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_Length = sizeof(test_osek_dataports__Integer);
  StatusType test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_ErrorCode = 0;
  test_osek_dataports_refined_model__the_proc_the_receiver_behaviorIdentifier_enum whichPortActivated = test_osek_dataports_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_receiver_entrypoint_impl_current_state)
  {
    case test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_dataports_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_dataports_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_ErrorCode = GetValueDataPort_runtime (p, &test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_localVariable);
      if (test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_ErrorCode == 0) {
      receive (test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl_p_localVariable);
      }
      break;
    }
  }
}
}
