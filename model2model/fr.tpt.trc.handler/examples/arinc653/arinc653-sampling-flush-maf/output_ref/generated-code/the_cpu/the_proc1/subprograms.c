#include "arinc653/sampling.h"
#include "subprograms.h"
test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_State_t the_proc1_the_sender_entrypoint_impl_current_state = test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl(SAMPLING_PORT_ID_TYPE *  cnx_p_out)
{
  RETURN_CODE_TYPE test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_the_proc1_the_sender_runtime_call_ret;
  common_pkg__Integer test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_p_out_localVariable;
  MESSAGE_SIZE_TYPE test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_p_out_Length = sizeof(common_pkg__Integer);
  test_sampling_refined_model__the_proc1_the_sender_behaviorIdentifier_enum whichPortActivated = test_sampling_refined_model__the_proc1_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc1_the_sender_entrypoint_impl_current_state)
  {
    case test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc1_the_sender_entrypoint_impl_current_state = test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_sampling_refined_model__the_proc1_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc1_the_sender_entrypoint_impl_current_state = test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_the_proc1_the_sender_runtime_call_ret);
      break;
    }
    case test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_sampling_refined_model__the_proc1_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc1_the_sender_entrypoint_impl_current_state = test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_p_out_localVariable);
      WRITE_SAMPLING_MESSAGE ((*cnx_p_out), &test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_p_out_localVariable, test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_p_out_Length, &test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl_the_proc1_the_sender_runtime_call_ret);
      break;
    }
  }
}
}
