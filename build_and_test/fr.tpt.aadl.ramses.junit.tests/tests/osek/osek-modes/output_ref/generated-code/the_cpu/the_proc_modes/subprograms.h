#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "user_receive.h"
#include "/home/castella/workspaces/runtime-New_configuration2/modes/user_send.h"
#include "osek_runtime.h"
#include "toppers_osek/include/kernel.h"
#include "kernel.h"
#include "gtypes.h"
#include "main.h"
void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl(thread_queue_t *  m1_the_sender_p_m2_p, thread_queue_t *  m2_the_sender_p_m1_p);

typedef enum {
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_init_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_exec_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_entrypoint_final_state
} test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_entrypoint_impl_BA_State_t;

void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl(data_port_t *  input_data_m1, data_port_t *  input_data_m2);

typedef enum {
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_init_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_exec_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_entrypoint_final_state
} test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_entrypoint_impl_BA_State_t;

void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl(data_port_t *  input_data);

typedef enum {
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_init_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_exec_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_entrypoint_final_state
} test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_entrypoint_impl_BA_State_t;

void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl(data_port_t *  input_data);

typedef enum {
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_init_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_exec_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_entrypoint_final_state
} test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_entrypoint_impl_BA_State_t;

void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl(thread_queue_t *  p_PortIdAccess_in, AppModeType *  targetModeValue_accessForBA, test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_currentState *  Parent_BA_currentState_Access);

typedef enum {
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_init_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_exec_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_entrypoint_final_state
} test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_entrypoint_impl_BA_State_t;

void test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl(thread_queue_t *  p_PortIdAccess_in, AppModeType *  targetModeValue_accessForBA, test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_currentState *  Parent_BA_currentState_Access);

typedef enum {
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_init_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_exec_state,
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_entrypoint_final_state
} test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_entrypoint_impl_BA_State_t;


#endif
