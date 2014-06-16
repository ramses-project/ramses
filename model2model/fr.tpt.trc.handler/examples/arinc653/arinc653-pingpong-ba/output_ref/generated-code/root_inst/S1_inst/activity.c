#include "activity.h"
#include "main.h"

extern TYPE State_baKeywords;
extern BLACKBOARD_ID_TYPE Monitor_changeState_error_C1_globalVariable;
extern BLACKBOARD_ID_TYPE Monitor_changeState_delayed_error_C2_globalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_Mon_mode_C2_globalVariable;
void PingPong_refined_model__S1_inst_Monitor_changeState_impl_Init()
{
}

void* PingPong_refined_model__S1_inst_Monitor_changeState_impl_Job()
{
  PingPong_refined_model__S1_inst_Monitor_changeState_currentState PingPong_refined_model__S1_inst_Monitor_changeState_impl_Parent_BA_currentState = PingPong_refined_model__S1_inst_Monitor_changeState_currentState_switch;
  while (1) {
    PingPong_refined_model__S1_inst_Monitor_changeState_entrypoint_impl (&State_baKeywords, &Monitor_changeState_error_C1_globalVariable, &Monitor_changeState_delayed_error_C2_globalVariable, &IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable, &IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable, &IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable, &S1_inst_Mon_mode_C2_globalVariable, &PingPong_refined_model__S1_inst_Monitor_changeState_impl_Parent_BA_currentState);
  }
  return 0;
}
extern TYPE State_baKeywords;
extern SAMPLING_PORT_ID_TYPE S1_inst_Mon_error_C2globalVariable;
extern BLACKBOARD_ID_TYPE Monitor_changeState_delayed_error_C2_globalVariable;
void PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_impl_Init()
{
}

void* PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_impl_Job()
{
  PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_currentState PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_impl_Parent_BA_currentState = PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_currentState_switch;
  while (1) {
    PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_entrypoint_impl (&State_baKeywords, &S1_inst_Mon_error_C2globalVariable, &Monitor_changeState_delayed_error_C2_globalVariable, &PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_impl_Parent_BA_currentState);
  }
  return 0;
}
extern SEQ seqNb;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PingOut_globalVariable;
extern BLACKBOARD_ID_TYPE Monitor_changeState_error_C1_globalVariable;
void PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_Init()
{
}

void* PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_Job()
{
  PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_currentState PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_Parent_BA_currentState = PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_currentState_switch;
  Base_Types__Integer_16 PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_PingOut_persistentFreshnessIndicator = 0;
  while (1) {
    PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_entrypoint_impl (&seqNb, &IPingOrPong_Cping_ping_delayed_PongIn_globalVariable, &IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable, &S1_inst_C1_PingOut_globalVariable, &Monitor_changeState_error_C1_globalVariable, &PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_Parent_BA_currentState, &PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_PingOut_persistentFreshnessIndicator);
  }
  return 0;
}
extern SEQ seqNb;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PongInglobalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable;
void PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_impl_Init()
{
}

void* PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_impl_Job()
{
  PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_currentState PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_impl_Parent_BA_currentState = PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_currentState_switch;
  while (1) {
    PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_entrypoint_impl (&seqNb, &S1_inst_C1_PongInglobalVariable, &IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable, &IPingOrPong_Cping_ping_delayed_PongIn_globalVariable, &PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_impl_Parent_BA_currentState);
  }
  return 0;
}
extern SEQ seqNb;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PingInglobalVariable;
extern BLACKBOARD_ID_TYPE IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PongOut_globalVariable;
void PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_Init()
{
}

void* PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_Job()
{
  PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_currentState PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_Parent_BA_currentState = PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_currentState_switch;
  Base_Types__Integer_16 PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_PingIn_persistentFreshnessIndicator = 0;
  while (1) {
    PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_entrypoint_impl (&seqNb, &S1_inst_C1_PingInglobalVariable, &IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable, &S1_inst_C1_PongOut_globalVariable, &PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_Parent_BA_currentState, &PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_PingIn_persistentFreshnessIndicator);
  }
  return 0;
}
