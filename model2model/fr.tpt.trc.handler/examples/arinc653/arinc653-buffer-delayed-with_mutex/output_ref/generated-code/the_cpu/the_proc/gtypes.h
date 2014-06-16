#ifndef __GENERATED_GTYPES_H__
#define __GENERATED_GTYPES_H__
#include "arinc653/types.h"
#include "arinc653/semaphore.h"
typedef  int common_pkg__Integer;
typedef signed int Base_Types__Integer_16;
typedef char Base_Types__Boolean;
typedef struct test_buffer_delayed_refined_model__Integer_Msg_impl {
	common_pkg__Integer MsgValue;
	Base_Types__Integer_16 Timestamp;
	Base_Types__Integer_16 PriorityValue;
	Base_Types__Boolean Consumed;
	Base_Types__Integer_16 Next;
} test_buffer_delayed_refined_model__Integer_Msg_impl;
typedef test_buffer_delayed_refined_model__Integer_Msg_impl test_buffer_delayed_refined_model__QueueType_the_receiver_p_in[10];
typedef  int Base_Types__Integer;
typedef struct test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl {
	test_buffer_delayed_refined_model__QueueType_the_receiver_p_in buffer;
	Base_Types__Integer first_write;
} test_buffer_delayed_refined_model__SharedStructType_the_receiver_p_in_impl;
typedef SEMAPHORE_ID_TYPE arinc653_runtime__Semaphore_Id_Type;
typedef RETURN_CODE_TYPE arinc653_runtime__Return_Code_Type;
typedef SYSTEM_TIME_TYPE arinc653_runtime__System_Time_Type;
typedef enum e_test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum {
	test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior
} test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum;
typedef enum e_test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum {
	test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior,
	test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_p_in
} test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum;
typedef enum e_PeriodicDelayedMutex_runtime__ReturnCodeType {
	PeriodicDelayedMutex_runtime__ReturnCodeType_Ok,
	PeriodicDelayedMutex_runtime__ReturnCodeType_EmptyQueue,
	PeriodicDelayedMutex_runtime__ReturnCodeType_FullQueue
} PeriodicDelayedMutex_runtime__ReturnCodeType;

#endif

