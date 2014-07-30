#ifndef __GENERATED_GTYPES_H__
#define __GENERATED_GTYPES_H__
#include "arinc653/types.h"
#include "arinc653/event.h"
#include "arinc653/buffer.h"
typedef BUFFER_ID_TYPE arinc653_runtime__Buffer_Id_Type;
typedef EVENT_ID_TYPE arinc653_runtime__Event_Id_Type;
typedef RETURN_CODE_TYPE arinc653_runtime__Return_Code_Type;
typedef signed int Base_Types__Integer_16;
typedef unsigned int Base_Types__Unsigned_8;
typedef struct __event_sender_spg_context {
	Base_Types__Unsigned_8 e;
} __event_sender_spg_context;
typedef enum e_test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum {
	test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior
} test_events_refined_model__the_proc_the_sender_behaviorIdentifier_enum;
typedef MESSAGE_SIZE_TYPE arinc653_runtime__Message_Size_Type;
typedef SYSTEM_TIME_TYPE arinc653_runtime__System_Time_Type;
typedef enum e_test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum {
	test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior,
	test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_p_in
} test_events_refined_model__the_proc_the_receiver_behaviorIdentifier_enum;

#endif

