#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "arinc653/error.h"
#include "arinc653/sampling.h"
#include "arinc653/time.h"
#include "arinc653/types.h"
#include "arinc653/process.h"
#include "user_code.h"
#include "arinc653/partition.h"
#include "gtypes.h"
#include "main.h"
void test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl(SAMPLING_PORT_ID_TYPE *  p_in);

typedef enum {
  test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_init_state,
  test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_exec_state,
  test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_entrypoint_final_state
} test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl_BA_State_t;

void test_sampling_refined_model__the_proc2_error_handler_spg();

typedef enum {
  test_sampling_refined_model__the_proc2_error_handler_spg_error_recovery_state,
  test_sampling_refined_model__the_proc2_error_handler_spg_switch_error_state
} test_sampling_refined_model__the_proc2_error_handler_spg_BA_State_t;


#endif

