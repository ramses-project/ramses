#include "toppers_osek/include/kernel.h"
#include "osek_runtime.h"
#include "subprograms.h"
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_State_t the_proc_modes_the_sender_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl(thread_queue_t *  m1_the_sender_p_m2_p, thread_queue_t *  m2_the_sender_p_m1_p)
{
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_the_proc_modes_the_sender_runtime_call_ret;
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_p_localVariable;
  __sender_spg_context test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_c_context = {0};
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_behaviorIdentifier_enum whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_modes_the_sender_entrypoint_impl_current_state)
  {
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_modes_the_sender_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_modes_the_sender_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_modes_the_sender_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_c_context);
      break;
    }
  }
}
}
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_State_t the_proc_modes_the_receiver_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl(data_port_t *  input_data_m1, data_port_t *  input_data_m2)
{
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_the_proc_modes_the_receiver_runtime_call_ret;
  test_osek_modes__Integer test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_localVariable;
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_Length = sizeof(test_osek_modes__Integer);
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_ErrorCode = 0;
  AppModeType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_the_receiver_currentMode;
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_behaviorIdentifier_enum whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_modes_the_receiver_entrypoint_impl_current_state)
  {
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_modes_the_receiver_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_modes_the_receiver_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_modes_the_receiver_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_the_receiver_currentMode = GetActiveApplicationMode ();
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_the_receiver_currentMode == m1) {
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_ErrorCode = GetValueDataPort_runtime (input_data_m1, &test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_localVariable);
      }
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_the_receiver_currentMode == m2) {
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_ErrorCode = GetValueDataPort_runtime (input_data_m2, &test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_localVariable);
      }
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_ErrorCode == 0) {
      receive (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_input_data_localVariable);
      }
      break;
    }
  }
}
}
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_State_t the_proc_modes_the_receiver_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl(data_port_t *  input_data_m1)
{
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_the_proc_modes_the_receiver_m1_runtime_call_ret;
  test_osek_modes__Integer test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_localVariable;
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_Length = sizeof(test_osek_modes__Integer);
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_ErrorCode = 0;
  AppModeType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_the_receiver_m1_currentMode;
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_behaviorIdentifier_enum whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_modes_the_receiver_m1_entrypoint_impl_current_state)
  {
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_modes_the_receiver_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_modes_the_receiver_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_modes_the_receiver_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_the_receiver_m1_currentMode = GetActiveApplicationMode ();
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_the_receiver_m1_currentMode == m1) {
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_ErrorCode = GetValueDataPort_runtime (input_data_m1, &test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_localVariable);
      }
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_ErrorCode == 0) {
      receive (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_input_data_localVariable);
      }
      break;
    }
  }
}
}
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_State_t the_proc_modes_the_receiver_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl(data_port_t *  input_data_m2)
{
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_the_proc_modes_the_receiver_m2_runtime_call_ret;
  test_osek_modes__Integer test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_localVariable;
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_Length = sizeof(test_osek_modes__Integer);
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_ErrorCode = 0;
  AppModeType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_the_receiver_m2_currentMode;
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_behaviorIdentifier_enum whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_modes_the_receiver_m2_entrypoint_impl_current_state)
  {
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_modes_the_receiver_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_modes_the_receiver_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_modes_the_receiver_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_the_receiver_m2_currentMode = GetActiveApplicationMode ();
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_the_receiver_m2_currentMode == m2) {
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_ErrorCode = GetValueDataPort_runtime (input_data_m2, &test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_localVariable);
      }
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_ErrorCode == 0) {
      receive (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_input_data_localVariable);
      }
      break;
    }
  }
}
}
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_State_t the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl(thread_queue_t *  p_PortIdAccess_in, AppModeType *  targetModeValue_accessForBA, test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_currentState *  Parent_BA_currentState_Access)
{
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_localVariable;
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_ErrorCode = 0;
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_the_proc_modes_the_proc_modes_mode_m1_runtime_call_ret;
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_countValue = 0;
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_behaviorIdentifier_enum whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_current_state)
  {
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: behavior_specification_1 -- Priority 0
    if(whichPortActivated == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_ErrorCode = ReceiveInputs_runtime (p_PortIdAccess_in, 0);
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_ErrorCode = GetCount_runtime (p_PortIdAccess_in, 0, &test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_countValue);
      if ((*Parent_BA_currentState_Access) == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_currentState_ModeSwitch_init_state) {
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_p_countValue != 0) {
      (*targetModeValue_accessForBA) = m2;
      StartOS ((*targetModeValue_accessForBA));
      }
      (*Parent_BA_currentState_Access) = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_currentState_ModeSwitch_init_state;
      TerminateTask ();
      }
      break;
    }
  }
}
}
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_State_t the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_init_state;
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl(thread_queue_t *  p_PortIdAccess_in, AppModeType *  targetModeValue_accessForBA, test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_currentState *  Parent_BA_currentState_Access)
{
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_localVariable;
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_ErrorCode = 0;
  StatusType test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_the_proc_modes_the_proc_modes_mode_m2_runtime_call_ret;
  Base_Types__Integer_16 test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_countValue = 0;
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_behaviorIdentifier_enum whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_current_state)
  {
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: behavior_specification_1 -- Priority 0
    if(whichPortActivated == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_current_state = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_ErrorCode = ReceiveInputs_runtime (p_PortIdAccess_in, 0);
      test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_ErrorCode = GetCount_runtime (p_PortIdAccess_in, 0, &test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_countValue);
      if ((*Parent_BA_currentState_Access) == test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_currentState_ModeSwitch_init_state) {
      if (test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_p_countValue != 0) {
      (*targetModeValue_accessForBA) = m1;
      StartOS ((*targetModeValue_accessForBA));
      }
      (*Parent_BA_currentState_Access) = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_currentState_ModeSwitch_init_state;
      TerminateTask ();
      }
      break;
    }
  }
}
}
