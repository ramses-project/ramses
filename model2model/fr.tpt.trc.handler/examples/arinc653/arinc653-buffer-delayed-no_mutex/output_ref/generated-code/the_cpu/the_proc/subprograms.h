#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "arinc653/types.h"
#include "arinc653/time.h"
#include "user_code.h"
#include "gtypes.h"
#include "main.h"
void test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl(test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl *  cnx_p_out);

typedef enum {
  test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state,
  test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state,
  test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_final_state
} test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t;

void test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl(test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl *  p_in);

typedef enum {
  test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state,
  test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state,
  test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_final_state
} test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t;

void test_buffer_delayed_refined_model__Put_Value_the_proc_the_sender_p_out(Base_Types__Integer_16 *  iteration_counter, PeriodicDelayed_runtime__ArrayDataType CDW, Base_Types__Integer_16 CDWSize, common_pkg__Integer pvalue, test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl *  buffer);

typedef enum {
  test_buffer_delayed_refined_model__Put_Value_the_proc_the_sender_p_out_s
} test_buffer_delayed_refined_model__Put_Value_the_proc_the_sender_p_out_BA_State_t;

void PeriodicDelayed_runtime__Send_Output(Base_Types__Integer_16 *  iteration_counter, Base_Types__Integer_16 CDWSize);

typedef enum {
  PeriodicDelayed_runtime__Send_Output_s
} PeriodicDelayed_runtime__Send_Output_BA_State_t;

void test_buffer_delayed_refined_model__Receive_Input_lowet_the_proc_the_receiver_p_in(Base_Types__Integer_16 *  iteration_counter, PeriodicDelayed_runtime__ArrayDataType CPR, Base_Types__Integer_16 CPRSize, Base_Types__Integer_16 *  first, Base_Types__Integer_16 *  last, Base_Types__Integer_16 bufferSize, PeriodicDelayed_runtime__ReturnCodeType *  ReturnCode);

typedef enum {
  test_buffer_delayed_refined_model__Receive_Input_lowet_the_proc_the_receiver_p_in_s
} test_buffer_delayed_refined_model__Receive_Input_lowet_the_proc_the_receiver_p_in_BA_State_t;

void test_buffer_delayed_refined_model__Next_Value_the_proc_the_receiver_p_in(Base_Types__Integer_16 *  first, Base_Types__Integer_16 last, test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl buffer, common_pkg__Integer *  output, Base_Types__Integer_16 bufferSize, PeriodicDelayed_runtime__ReturnCodeType *  ReturnCode);

typedef enum {
  test_buffer_delayed_refined_model__Next_Value_the_proc_the_receiver_p_in_s
} test_buffer_delayed_refined_model__Next_Value_the_proc_the_receiver_p_in_BA_State_t;


#endif

