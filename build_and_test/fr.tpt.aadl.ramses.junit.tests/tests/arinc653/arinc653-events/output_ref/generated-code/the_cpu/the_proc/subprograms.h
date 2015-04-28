#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "event_code.h"
#include "arinc653/time.h"
#include "/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/common-components/event_code.h"
#include "arinc653/types.h"
#include "arinc653/event.h"
#include "arinc653/buffer.h"
#include "gtypes.h"
#include "main.h"
void test_events_refined_model__the_proc_the_sender_entrypoint_impl(
	BUFFER_ID_TYPE *  cnx_p_out,
	EVENT_ID_TYPE *  cnx_p_out_entrypoint_barrier);

typedef enum {
  test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state,
  test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state,
  test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_entrypoint_final_state
} test_events_refined_model__the_proc_the_sender_entrypoint_impl_BA_State_t;

void test_events_refined_model__the_proc_the_receiver_entrypoint_impl(
	BUFFER_ID_TYPE *  p_in,
	EVENT_ID_TYPE *  the_receiver_PortIdAccess_barrier);

typedef enum {
  test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state,
  test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state,
  test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_entrypoint_final_state
} test_events_refined_model__the_proc_the_receiver_entrypoint_impl_BA_State_t;


#endif

