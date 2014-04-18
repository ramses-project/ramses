#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "arinc653/time.h"
#include "arinc653/types.h"
#include "user_code.h"
#include "arinc653/buffer.h"
#include "gtypes.h"
#include "main.h"
void test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl(BUFFER_ID_TYPE *  cnx_p_out);

typedef enum {
  test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state,
  test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state,
  test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_final_state
} test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t;

void test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl(BUFFER_ID_TYPE *  p_in);

typedef enum {
  test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state,
  test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state,
  test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_final_state
} test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t;

void test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl();

typedef enum {
  test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl_BA_entrypoint_init_state,
  test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl_BA_entrypoint_exec_state,
  test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl_BA_entrypoint_final_state
} test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl_BA_State_t;


#endif

