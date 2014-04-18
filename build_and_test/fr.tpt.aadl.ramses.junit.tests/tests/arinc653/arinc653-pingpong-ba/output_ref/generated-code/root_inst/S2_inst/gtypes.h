#ifndef __GENERATED_GTYPES_H__
#define __GENERATED_GTYPES_H__
#include "arinc653/sampling.h"
#include "arinc653/types.h"
#include "arinc653/blackboard.h"
#include "business-code/PingPong_module.h"
typedef enum e_PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState {
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState_switch
} PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_currentState;
typedef signed int Base_Types__Integer_16;
typedef  int COAL__integer;
typedef SEQ PingPong__SEQ;
typedef BLACKBOARD_ID_TYPE arinc653_runtime__Blackboard_Id_Type;
typedef SAMPLING_PORT_ID_TYPE arinc653_runtime__Sampling_Port_Id_Type;
typedef struct PingPong__PingPongMessage {
} PingPong__PingPongMessage;
typedef MESSAGE_SIZE_TYPE arinc653_runtime__Message_Size_Type;
typedef struct PingPong_refined_model__PingPongMessage_freshness_t_impl {
	PingPongMessage pvalue;
	Base_Types__Integer_16 fresh_ba;
} PingPong_refined_model__PingPongMessage_freshness_t_impl;
typedef enum e_PingPong__Exception {
	PingPong__Exception_E_EXCEPTION_NO_ERROR,
	PingPong__Exception_E_EXCEPTION_BAD_SEQUENCE_NUMBER
} PingPong__Exception;
typedef enum e_PingPong__ROLE {
	PingPong__ROLE_E_ROLE_CPING,
	PingPong__ROLE_E_ROLE_CPONG
} PingPong__ROLE;
typedef RETURN_CODE_TYPE arinc653_runtime__Return_Code_Type;
typedef VALIDITY_TYPE arinc653_runtime__Validity_Type;
typedef SYSTEM_TIME_TYPE arinc653_runtime__System_Time_Type;
typedef enum e_PingPong_refined_model__S1_inst_Monitor_changeState_behaviorIdentifier_enum {
	PingPong_refined_model__S1_inst_Monitor_changeState_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S1_inst_Monitor_changeState_behaviorIdentifier_enum_error_C1,
	PingPong_refined_model__S1_inst_Monitor_changeState_behaviorIdentifier_enum_delayed_error_C2
} PingPong_refined_model__S1_inst_Monitor_changeState_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_behaviorIdentifier_enum {
	PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_behaviorIdentifier_enum_error_C2
} PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum {
	PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum_delayed_PongIn,
	PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum_mode_aadlKeywords
} PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum {
	PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum_PongIn,
	PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum_mode_aadlKeywords
} PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum {
	PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum_PingIn,
	PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum_mode_aadlKeywords
} PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum {
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum_delayed_PongIn,
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum_mode_aadlKeywords
} PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState {
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState_switch
} PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_currentState;
typedef enum e_PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum {
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum_PongIn,
	PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum_mode_aadlKeywords
} PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_behaviorIdentifier_enum;
typedef enum e_PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState {
	PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState_switch
} PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_currentState;
typedef enum e_PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum {
	PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum_PingIn,
	PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum_mode_aadlKeywords
} PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_behaviorIdentifier_enum;

#endif

