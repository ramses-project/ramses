#ifndef __GENERATED_GTYPES_H__
#define __GENERATED_GTYPES_H__
#include "pingpong.h"
#include "arinc653/sampling.h"
#include "arinc653/types.h"
typedef char * PingPong__TYPE_aadlKeywords;
typedef  int PingPong__SEQ;
typedef SAMPLING_PORT_ID_TYPE arinc653_runtime__Sampling_Port_Id_Type;
typedef RETURN_CODE_TYPE arinc653_runtime__Return_Code_Type;
typedef enum e_PingPong__ROLE {
	PingPong__ROLE_PING,
	PingPong__ROLE_PONG,
	PingPong__ROLE_UNCONNECTED
} PingPong__ROLE;
typedef MESSAGE_SIZE_TYPE arinc653_runtime__Message_Size_Type;
typedef enum e_PingPong__ID {
	PingPong__ID_Cping,
	PingPong__ID_Cpong
} PingPong__ID;
typedef struct PingPong__PingPongMessage {
	TYPE m_type;
	ID m_sender;
	SEQ m_seqNb;
} PingPong__PingPongMessage;
typedef  int PingPong__Exception;
typedef VALIDITY_TYPE arinc653_runtime__Validity_Type;
typedef enum e_PingPong_refined_model__S1_inst_a1_inst_behaviorIdentifier_enum {
	PingPong_refined_model__S1_inst_a1_inst_behaviorIdentifier_enum_default_behavior,
	PingPong_refined_model__S1_inst_a1_inst_behaviorIdentifier_enum_C1_PingIn,
	PingPong_refined_model__S1_inst_a1_inst_behaviorIdentifier_enum_C1_PongIn,
	PingPong_refined_model__S1_inst_a1_inst_behaviorIdentifier_enum_Mon_error_C2
} PingPong_refined_model__S1_inst_a1_inst_behaviorIdentifier_enum;

#endif

