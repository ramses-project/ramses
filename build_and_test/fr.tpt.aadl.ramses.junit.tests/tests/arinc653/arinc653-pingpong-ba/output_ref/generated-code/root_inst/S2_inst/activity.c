#include "activity.h"
#include "main.h"

extern SEQ seqNb;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_modeglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PingOut_globalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_badSequenceNumber_globalVariable;
void* PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_impl_Job()
{
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_impl_Parent_BA_currentState = PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState_switch;
  Base_Types__Integer_16 PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_impl_PingOut_persistentFreshnessIndicator = 0;
  while (1) {
    PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_entrypoint_impl (&seqNb, &IPingOrPong_Cping_ping_delayed_PongIn_globalVariable, &S2_inst_C2_modeglobalVariable, &S2_inst_C2_PingOut_globalVariable, &S2_inst_C2_badSequenceNumber_globalVariable, &PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_impl_Parent_BA_currentState, &PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_impl_PingOut_persistentFreshnessIndicator);
  }
  return 0;
}
extern SEQ seqNb;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PongInglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_modeglobalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable;
void* PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_impl_Job()
{
  PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_impl_Parent_BA_currentState = PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState_switch;
  while (1) {
    PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl (&seqNb, &S2_inst_C2_PongInglobalVariable, &S2_inst_C2_modeglobalVariable, &IPingOrPong_Cping_ping_delayed_PongIn_globalVariable, &PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_impl_Parent_BA_currentState);
  }
  return 0;
}
extern SEQ seqNb;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PingInglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_modeglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PongOut_globalVariable;
void* PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_impl_Job()
{
  PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_impl_Parent_BA_currentState = PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState_switch;
  Base_Types__Integer_16 PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_impl_PingIn_persistentFreshnessIndicator = 0;
  while (1) {
    PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_entrypoint_impl (&seqNb, &S2_inst_C2_PingInglobalVariable, &S2_inst_C2_modeglobalVariable, &S2_inst_C2_PongOut_globalVariable, &PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_impl_Parent_BA_currentState, &PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_impl_PingIn_persistentFreshnessIndicator);
  }
  return 0;
}
