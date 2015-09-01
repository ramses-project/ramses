#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "pingpong.h"
#include "arinc653/sampling.h"
#include "arinc653/time.h"
#include "arinc653/types.h"
#include "gtypes.h"
#include "main.h"
void PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl(
	SAMPLING_PORT_ID_TYPE *  C2_mode,
	SAMPLING_PORT_ID_TYPE *  C2_PingIn,
	SAMPLING_PORT_ID_TYPE *  C2_PongIn,
	SAMPLING_PORT_ID_TYPE *  C2_ping_implicit_cnx_C2_PingOut,
	SAMPLING_PORT_ID_TYPE *  C2_pong_implicit_cnx_C2_PongOut,
	SAMPLING_PORT_ID_TYPE *  C2_error_implicit_cnx_C2_badSequenceNumber,
	SEQ *  PingPong_a2_impl_call_seq_PingPong_IPingOrPong_mode_seqNb_entrypoint);

typedef enum {
  PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl_BA_entrypoint_init_state,
  PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl_BA_entrypoint_exec_state,
  PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl_BA_entrypoint_final_state
} PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl_BA_State_t;


#endif

