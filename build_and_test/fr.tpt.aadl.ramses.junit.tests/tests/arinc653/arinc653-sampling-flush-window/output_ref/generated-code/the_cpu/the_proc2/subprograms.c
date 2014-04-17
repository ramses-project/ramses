#include "arinc653/sampling.h"
#include "subprograms.h"
test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_State_t the_proc2_the_receiver_entrypoint_impl_current_state = test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl(SAMPLING_PORT_ID_TYPE *  p_in)
{
  RETURN_CODE_TYPE test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_the_proc2_the_receiver_runtime_call_ret;
  common_pkg__Integer test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_localVariable;
  MESSAGE_SIZE_TYPE test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_Length = sizeof(common_pkg__Integer);
  RETURN_CODE_TYPE test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_ErrorCode = 0;
  VALIDITY_TYPE test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_Validity;
  test_sampling_refined_model__the_proc2_the_receiver_behaviorIdentifier_enum whichPortActivated = test_sampling_refined_model__the_proc2_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc2_the_receiver_entrypoint_impl_current_state)
  {
    case test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc2_the_receiver_entrypoint_impl_current_state = test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_sampling_refined_model__the_proc2_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc2_the_receiver_entrypoint_impl_current_state = test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_the_proc2_the_receiver_runtime_call_ret);
      break;
    }
    case test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_sampling_refined_model__the_proc2_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc2_the_receiver_entrypoint_impl_current_state = test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      READ_SAMPLING_MESSAGE ((*p_in), &test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_localVariable, test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_Length, &test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_Validity, &test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_ErrorCode);
      if (test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_ErrorCode == 0) {
      receive (test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_p_in_localVariable);
      }
      break;
    }
  }
}
}
test_sampling_refined_model__the_proc2_error_handler_spg_BA_State_t the_proc2_error_handler_spg_current_state = test_sampling_refined_model__the_proc2_error_handler_spg_error_recovery_state;
void test_sampling_refined_model__the_proc2_error_handler_spg()
{
  ERROR_STATUS_TYPE error_status;
RETURN_CODE_TYPE error_code;
while(1)
{
  switch(the_proc2_error_handler_spg_current_state)
  {
    case test_sampling_refined_model__the_proc2_error_handler_spg_error_recovery_state:
    // Transition id: get_error_transition
    if(1) // no execution condition
    {
      the_proc2_error_handler_spg_current_state = test_sampling_refined_model__the_proc2_error_handler_spg_switch_error_state;
      STOP_SELF ();
      GET_ERROR_STATUS (&error_status, &error_code);
      break;
    }
    case test_sampling_refined_model__the_proc2_error_handler_spg_switch_error_state:
    // Transition id: action_Numeric_Error
    if(error_status.ERROR_CODE == NUMERIC_ERROR)
    {
      the_proc2_error_handler_spg_current_state = test_sampling_refined_model__the_proc2_error_handler_spg_error_recovery_state;
      if (error_status.FAILED_PROCESS_ID == 1) {
      START (error_status.FAILED_PROCESS_ID, &error_code);
      STOP (error_status.FAILED_PROCESS_ID, &error_code);
      }
      return;
    }
    // Transition id: action_Illegal_Request
    if(error_status.ERROR_CODE == ILLEGAL_REQUEST)
    {
      the_proc2_error_handler_spg_current_state = test_sampling_refined_model__the_proc2_error_handler_spg_error_recovery_state;
      if (error_status.FAILED_PROCESS_ID == 1) {
      SET_PARTITION_MODE (WARM_START, &error_code);
      }
      return;
    }
  }
}
}
