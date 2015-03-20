#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "arinc653/sampling.h"
#include "arinc653/time.h"
#include "arinc653/types.h"
#include "pingpong.h"
#include "gtypes.h"
#include "main.h"
void PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl(SAMPLING_PORT_ID_TYPE *  C1_PingIn, SAMPLING_PORT_ID_TYPE *  C1_PongIn, SAMPLING_PORT_ID_TYPE *  Mon_error_C2, SAMPLING_PORT_ID_TYPE *  mode_implicit_cnx_Mon_mode_C2, SAMPLING_PORT_ID_TYPE *  C1_ping_implicit_cnx_C1_PingOut, SAMPLING_PORT_ID_TYPE *  C1_pong_implicit_cnx_C1_PongOut, TYPE *  PingPong_a1_impl_call_seq_PingPong_Monitor_activate_state_baKeywords_entrypoint, SEQ *  PingPong_a1_impl_call_seq_PingPong_IPingOrPong_mode_seqNb_entrypoint);

typedef enum {
  PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl_BA_entrypoint_init_state,
  PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl_BA_entrypoint_exec_state,
  PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl_BA_entrypoint_final_state
} PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl_BA_State_t;


#endif

