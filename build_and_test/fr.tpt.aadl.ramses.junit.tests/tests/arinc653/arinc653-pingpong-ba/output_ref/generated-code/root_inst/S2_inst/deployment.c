#include "deployment.h"
SAMPLING_PORT_ID_TYPE S2_inst_C2_PongOut_globalVariable;
SEQ seqNb;
SAMPLING_PORT_ID_TYPE S2_inst_C2_modeglobalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PingOut_globalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PongInglobalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PingInglobalVariable;
PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState IPingOrPong_Cping_pingParent_BA_currentState = PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState_switch;
BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable;
PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState IPingOrPong_Cpong_pongParent_BA_currentState = PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState_switch;
PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState IPingOrPong_Cping_delayed_PongInParent_BA_currentState = PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState_switch;
SAMPLING_PORT_ID_TYPE S2_inst_C2_badSequenceNumber_globalVariable;
