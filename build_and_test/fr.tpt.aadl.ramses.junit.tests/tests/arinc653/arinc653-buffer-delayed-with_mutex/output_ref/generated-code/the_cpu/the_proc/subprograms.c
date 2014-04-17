#include "arinc653/semaphore.h"
#include "subprograms.h"
test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t the_proc_the_sender_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
void test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl(test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl *  cnx_p_out, SEMAPHORE_ID_TYPE *  p_out_entrypointSemAccess)
{
  RETURN_CODE_TYPE test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret;
  common_pkg__Integer test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_IterationCounter = 0;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_the_sender_p_out_CDWSize_eventdata_receiver_p_in = 3;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_CurrentDeadline = 2000;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_DeadlineValue = 2000;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_PeriodValue = 2000;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_CurrentPeriod = 0;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_MsgPriority = 5;
  SYSTEM_TIME_TYPE test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_semTimeOut = -1;
  RETURN_CODE_TYPE test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_SemErrorCode = 0;
  test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum whichPortActivated = test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_sender_entrypoint_impl_current_state)
  {
    case test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      break;
    }
    case test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_sender_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      send (&test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable);
      WAIT_SEMAPHORE ((*p_out_entrypointSemAccess), test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_semTimeOut, &test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_SemErrorCode);
      test_buffer_delayed_refined_model__Put_Value_the_sender_p_out_impl (cnx_p_out, &test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_localVariable, test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_CurrentDeadline, test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_MsgPriority, 10);
      SIGNAL_SEMAPHORE ((*p_out_entrypointSemAccess), &test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_p_out_SemErrorCode);
      PeriodicDelayedMutex_runtime__Send_Output (test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_PeriodValue, test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_DeadlineValue, &test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_CurrentPeriod, &test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_CurrentDeadline);
      break;
    }
  }
}
}
test_buffer_delayed_refined_model__p_in_Init_Spg_BA_State_t p_in_Init_Spg_current_state = test_buffer_delayed_refined_model__p_in_Init_Spg_s;
void test_buffer_delayed_refined_model__p_in_Init_Spg(test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl *  BufferAccess, Base_Types__Integer_16 Size)
{
  Base_Types__Integer_16 j;
while(1)
{
  switch(p_in_Init_Spg_current_state)
  {
    case test_buffer_delayed_refined_model__p_in_Init_Spg_s:
    // Transition id: t
    if(1) // no execution condition
    {
      p_in_Init_Spg_current_state = test_buffer_delayed_refined_model__p_in_Init_Spg_s;
      (*BufferAccess).first_write = -1;
      while (j < Size)
      {
        (*BufferAccess).buffer[j].Next = -2;
        j = j + 1;
      }
      return;
    }
  }
}
}
test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
void test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl(test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl *  p_in, SEMAPHORE_ID_TYPE *  p_in_entrypointSemAccess)
{
  RETURN_CODE_TYPE test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret;
  RETURN_CODE_TYPE test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode = 0;
  common_pkg__Integer test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_IterationCounter = 0;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_CPRSize = 6;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_lastIndex = -1;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_readIndex = -1;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_the_receiver_p_in_BufferSize = 3;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_CurrentDeadline = 1000;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_DeadlineValue = 1000;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_PeriodValue = 1000;
  Base_Types__Integer_16 test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_CurrentPeriod = 0;
  SYSTEM_TIME_TYPE test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_semTimeOut = -1;
  RETURN_CODE_TYPE test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_SemErrorCode = 0;
  test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum whichPortActivated = test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(the_proc_the_receiver_entrypoint_impl_current_state)
  {
    case test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      break;
    }
    case test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call -- Priority 0
    if(whichPortActivated == test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior)
    {
      the_proc_the_receiver_entrypoint_impl_current_state = test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      test_buffer_delayed_refined_model__Receive_Input_mutex_the_receiver_p_in_impl (p_in, test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_PeriodValue, test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_CurrentPeriod);
      WAIT_SEMAPHORE ((*p_in_entrypointSemAccess), test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_semTimeOut, &test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_SemErrorCode);
      test_buffer_delayed_refined_model__Next_Value_the_receiver_p_in_impl (p_in, &test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable, test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_CurrentPeriod, &test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode);
      SIGNAL_SEMAPHORE ((*p_in_entrypointSemAccess), &test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_SemErrorCode);
      if (test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_ErrorCode == 0) {
      receive (test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_p_in_localVariable);
      }
      PeriodicDelayedMutex_runtime__Send_Output (test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_PeriodValue, test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_DeadlineValue, &test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_CurrentPeriod, &test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_CurrentDeadline);
      break;
    }
  }
}
}
test_buffer_delayed_refined_model__Put_Value_the_sender_p_out_impl_BA_State_t Put_Value_the_sender_p_out_impl_current_state = test_buffer_delayed_refined_model__Put_Value_the_sender_p_out_impl_s;
void test_buffer_delayed_refined_model__Put_Value_the_sender_p_out_impl(test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl *  BufferAccess, common_pkg__Integer *  DataValue, Base_Types__Integer_16 CurrentDeadline, Base_Types__Integer_16 PriorityValue, Base_Types__Integer_16 Size)
{
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Put_Value_impl_previous_j = 0;
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Put_Value_impl_j = 0;
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot = 0;
  Base_Types__Boolean isHigherPrio;
Base_Types__Integer_16 date;
while(1)
{
  switch(Put_Value_the_sender_p_out_impl_current_state)
  {
    case test_buffer_delayed_refined_model__Put_Value_the_sender_p_out_impl_s:
    // Transition id: t
    if(1) // no execution condition
    {
      Put_Value_the_sender_p_out_impl_current_state = test_buffer_delayed_refined_model__Put_Value_the_sender_p_out_impl_s;
      while (PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot < Size && (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Next != -2)
      {
        PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot = PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot + 1;
      }
      (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].MsgValue = (*DataValue);
      (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].PriorityValue = PriorityValue;
      (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Timestamp = CurrentDeadline;
      PeriodicDelayedMutex_runtime__Put_Value_impl_j = (*BufferAccess).first_write;
      isHigherPrio = ((*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].Timestamp < (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Timestamp) || ((*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].Timestamp == (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Timestamp && (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].PriorityValue < (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].PriorityValue);
      while (PeriodicDelayedMutex_runtime__Put_Value_impl_j >= 0 && isHigherPrio == 1)
      {
        isHigherPrio = ((*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].Timestamp < (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Timestamp) || ((*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].Timestamp == (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Timestamp && (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].PriorityValue < (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].PriorityValue);
        PeriodicDelayedMutex_runtime__Put_Value_impl_previous_j = PeriodicDelayedMutex_runtime__Put_Value_impl_j;
        PeriodicDelayedMutex_runtime__Put_Value_impl_j = (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_j].Next;
      }
      if (PeriodicDelayedMutex_runtime__Put_Value_impl_j == (*BufferAccess).first_write) {
      (*BufferAccess).first_write = PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot;
      }
      else {
      (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_previous_j].Next = PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot;
      }
      (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Put_Value_impl_empty_slot].Next = PeriodicDelayedMutex_runtime__Put_Value_impl_j;
      return;
    }
  }
}
}
PeriodicDelayedMutex_runtime__Send_Output_BA_State_t Send_Output_current_state = PeriodicDelayedMutex_runtime__Send_Output_s;
void PeriodicDelayedMutex_runtime__Send_Output(Base_Types__Integer_16 PeriodValue, Base_Types__Integer_16 DeadlineValue, Base_Types__Integer_16 *  CurrentPeriod, Base_Types__Integer_16 *  CurrentDeadline)
{
  while(1)
{
  switch(Send_Output_current_state)
  {
    case PeriodicDelayedMutex_runtime__Send_Output_s:
    // Transition id: t
    if(1) // no execution condition
    {
      Send_Output_current_state = PeriodicDelayedMutex_runtime__Send_Output_s;
      (*CurrentPeriod) = (*CurrentPeriod) + PeriodValue;
      (*CurrentDeadline) = (*CurrentPeriod) + DeadlineValue;
      return;
    }
  }
}
}
test_buffer_delayed_refined_model__Receive_Input_mutex_the_receiver_p_in_impl_BA_State_t Receive_Input_mutex_the_receiver_p_in_impl_current_state = test_buffer_delayed_refined_model__Receive_Input_mutex_the_receiver_p_in_impl_s;
void test_buffer_delayed_refined_model__Receive_Input_mutex_the_receiver_p_in_impl(test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl *  BufferAccess, Base_Types__Integer_16 PeriodValue, Base_Types__Integer_16 CurrentPeriod)
{
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Receive_Input_impl_j;
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Receive_Input_impl_temp;
  while(1)
{
  switch(Receive_Input_mutex_the_receiver_p_in_impl_current_state)
  {
    case test_buffer_delayed_refined_model__Receive_Input_mutex_the_receiver_p_in_impl_s:
    // Transition id: t
    if(1) // no execution condition
    {
      Receive_Input_mutex_the_receiver_p_in_impl_current_state = test_buffer_delayed_refined_model__Receive_Input_mutex_the_receiver_p_in_impl_s;
      PeriodicDelayedMutex_runtime__Receive_Input_impl_j = (*BufferAccess).first_write;
      while (PeriodicDelayedMutex_runtime__Receive_Input_impl_j != -1 && ((*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Receive_Input_impl_j].Timestamp <= CurrentPeriod - PeriodValue))
      {
        (*BufferAccess).first_write = (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Receive_Input_impl_j].Next;
        (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Receive_Input_impl_j].Next = -2;
        PeriodicDelayedMutex_runtime__Receive_Input_impl_j = (*BufferAccess).first_write;
      }
      return;
    }
  }
}
}
test_buffer_delayed_refined_model__Next_Value_the_receiver_p_in_impl_BA_State_t Next_Value_the_receiver_p_in_impl_current_state = test_buffer_delayed_refined_model__Next_Value_the_receiver_p_in_impl_s;
void test_buffer_delayed_refined_model__Next_Value_the_receiver_p_in_impl(test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl *  BufferAccess, common_pkg__Integer *  DataValue, Base_Types__Integer_16 CurrentPeriod, PeriodicDelayedMutex_runtime__ReturnCodeType *  BufferState)
{
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Next_Value_impl_tmp;
  Base_Types__Integer_16 PeriodicDelayedMutex_runtime__Next_Value_impl_j;
  while(1)
{
  switch(Next_Value_the_receiver_p_in_impl_current_state)
  {
    case test_buffer_delayed_refined_model__Next_Value_the_receiver_p_in_impl_s:
    // Transition id: t
    if(1) // no execution condition
    {
      Next_Value_the_receiver_p_in_impl_current_state = test_buffer_delayed_refined_model__Next_Value_the_receiver_p_in_impl_s;
      if ((*BufferAccess).first_write != -1) {
      (*BufferState) = PeriodicDelayedMutex_runtime__ReturnCodeType_Ok;
      if ((*BufferAccess).buffer[(*BufferAccess).first_write].Timestamp <= CurrentPeriod) {
      (*DataValue) = (*BufferAccess).buffer[(*BufferAccess).first_write].MsgValue;
      PeriodicDelayedMutex_runtime__Next_Value_impl_tmp = (*BufferAccess).first_write;
      (*BufferAccess).first_write = (*BufferAccess).buffer[(*BufferAccess).first_write].Next;
      (*BufferAccess).buffer[PeriodicDelayedMutex_runtime__Next_Value_impl_tmp].Next = -2;
      }
      else {
      (*BufferState) = PeriodicDelayedMutex_runtime__ReturnCodeType_EmptyQueue;
      }
      }
      else {
      (*BufferState) = PeriodicDelayedMutex_runtime__ReturnCodeType_EmptyQueue;
      }
      return;
    }
  }
}
}
