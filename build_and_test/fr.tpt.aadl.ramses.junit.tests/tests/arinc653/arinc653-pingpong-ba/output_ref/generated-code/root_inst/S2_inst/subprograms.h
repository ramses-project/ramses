#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "business-code/PingPong_Protocol_Implementations_IPingOrPong_impl.h"
#include "business-code/PingPong_module.h"
#include "arinc653/sampling.h"
#include "arinc653/blackboard.h"
#include "arinc653/time.h"
#include "arinc653/types.h"
#include "gtypes.h"
#include "main.h"
void PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl(
	BLACKBOARD_ID_TYPE *  delayed_PongIn,
	SAMPLING_PORT_ID_TYPE *  PortCnx6_PingOut,
	SAMPLING_PORT_ID_TYPE *  PortCnx8_badSequenceNumber,
	SAMPLING_PORT_ID_TYPE *  mode_aadlKeywords,
	SEQ *  seqNb,
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState *  Parent_BA_currentState_Access,
	Base_Types__Integer_16 *  PingOut_freshnessIndicator_access);

typedef enum {
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl_BA_entrypoint_init_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl_BA_entrypoint_exec_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl_BA_entrypoint_final_state
} PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl_BA_State_t;

void PingPong__IPingOrPong_Cping_delayed_PongIn(
	PingPongMessage *  PongIn,
	PingPongMessage *  delayed_PongIn);

void PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl(
	SAMPLING_PORT_ID_TYPE *  PongIn,
	BLACKBOARD_ID_TYPE *  PortCnx9_delayed_PongIn,
	SAMPLING_PORT_ID_TYPE *  mode_aadlKeywords,
	SEQ *  seqNb,
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState *  Parent_BA_currentState_Access);

typedef enum {
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl_BA_entrypoint_init_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl_BA_entrypoint_exec_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl_BA_entrypoint_final_state
} PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl_BA_State_t;

void PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl(
	SAMPLING_PORT_ID_TYPE *  PingIn,
	SAMPLING_PORT_ID_TYPE *  PortCnx7_PongOut,
	SAMPLING_PORT_ID_TYPE *  mode_aadlKeywords,
	SEQ *  seqNb,
	PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState *  Parent_BA_currentState_Access,
	Base_Types__Integer_16 *  PingIn_freshnessIndicator_access);

typedef enum {
  PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl_BA_entrypoint_init_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl_BA_entrypoint_exec_state,
  PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl_BA_entrypoint_final_state
} PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl_BA_State_t;


#endif

