#include "arinc653/blackboard.h"
#include "subprograms.h"
test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t the_proc_the_sender_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl(BLACKBOARD_ID_TYPE *  cnx_p_out)
{
  RETURN_CODE_TYPE test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret;
  common_pkg__Integer test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable;
  MESSAGE_SIZE_TYPE test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_p_out_Length = sizeof(common_pkg__Integer);
  test_blackboard_refined_model__the_proc_the_sender_behaviorIdentifier_enum whichPortActivated = test_blackboard_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_sender_entrypoint_impl_current_state)
  {
    case test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_blackboard_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      break;
    }
    case test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_blackboard_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable);
      DISPLAY_BLACKBOARD ((*cnx_p_out), &test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable, test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_p_out_Length, &test_blackboard_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      break;
    }
  }
}
}
test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t the_proc_the_receiver_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl(BLACKBOARD_ID_TYPE *  p_in)
{
  RETURN_CODE_TYPE test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret;
  common_pkg__Integer test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable;
  MESSAGE_SIZE_TYPE test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_Length = sizeof(common_pkg__Integer);
  RETURN_CODE_TYPE test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode = 0;
  SYSTEM_TIME_TYPE test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_TimeOut = 0;
  test_blackboard_refined_model__the_proc_the_receiver_behaviorIdentifier_enum whichPortActivated = test_blackboard_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_receiver_entrypoint_impl_current_state)
  {
    case test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_blackboard_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      break;
    }
    case test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_blackboard_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      READ_BLACKBOARD ((*p_in), test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_TimeOut, &test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable, &test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_Length, &test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode);
      if (test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode == 0) {
      receive (test_blackboard_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable);
      }
      break;
    }
  }
}
}
test_blackboard_refined_model__the_proc_error_handler_spg_BA_State_t the_proc_error_handler_spg_current_state = test_blackboard_refined_model__the_proc_error_handler_spg_error_recovery_state;
void test_blackboard_refined_model__the_proc_error_handler_spg()
{
  ERROR_STATUS_TYPE error_status;
RETURN_CODE_TYPE error_code;
while(1)
{
  switch(the_proc_error_handler_spg_current_state)
  {
    case test_blackboard_refined_model__the_proc_error_handler_spg_error_recovery_state:
    // Transition id: get_error_transition
    if(1) // no execution condition
    {
      the_proc_error_handler_spg_current_state = test_blackboard_refined_model__the_proc_error_handler_spg_switch_error_state;
      STOP_SELF ();
      GET_ERROR_STATUS (&error_status, &error_code);
      break;
    }
    case test_blackboard_refined_model__the_proc_error_handler_spg_switch_error_state:
    // Transition id: action_Numeric_Error
    if(error_status.ERROR_CODE == NUMERIC_ERROR)
    {
      the_proc_error_handler_spg_current_state = test_blackboard_refined_model__the_proc_error_handler_spg_error_recovery_state;
      if (error_status.FAILED_PROCESS_ID == 1) {
      START (error_status.FAILED_PROCESS_ID, &error_code);
      STOP (error_status.FAILED_PROCESS_ID, &error_code);
      }
      if (error_status.FAILED_PROCESS_ID == 2) {
      START (error_status.FAILED_PROCESS_ID, &error_code);
      STOP (error_status.FAILED_PROCESS_ID, &error_code);
      }
      return;
    }
    // Transition id: action_Illegal_Request
    if(error_status.ERROR_CODE == ILLEGAL_REQUEST)
    {
      the_proc_error_handler_spg_current_state = test_blackboard_refined_model__the_proc_error_handler_spg_error_recovery_state;
      if (error_status.FAILED_PROCESS_ID == 1) {
      SET_PARTITION_MODE (WARM_START, &error_code);
      }
      if (error_status.FAILED_PROCESS_ID == 2) {
      SET_PARTITION_MODE (WARM_START, &error_code);
      }
      return;
    }
  }
}
}
