#ifndef __GENERATED_GTYPES_H__
#define __GENERATED_GTYPES_H__
#include "arinc653/types.h"
typedef signed int Base_Types__Integer_16;
typedef Base_Types__Integer_16 test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl[6];
typedef RETURN_CODE_TYPE arinc653_runtime__Return_Code_Type;
typedef  int common_pkg__Integer;
typedef Base_Types__Integer_16 test_buffer_delayed_refined_model__IndexArrayType_the_sender_p_out[3];
typedef enum e_test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum {
	test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum_default_behavior
} test_buffer_delayed_refined_model__the_proc_the_sender_behaviorIdentifier_enum;
typedef Base_Types__Integer_16 test_buffer_delayed_refined_model__IndexArrayType_the_receiver_p_in[6];
typedef enum e_test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum {
	test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_default_behavior,
	test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum_p_in
} test_buffer_delayed_refined_model__the_proc_the_receiver_behaviorIdentifier_enum;
typedef Base_Types__Integer_16 PeriodicDelayed_runtime__ArrayDataType[];
typedef enum e_PeriodicDelayed_runtime__ReturnCodeType {
	PeriodicDelayed_runtime__ReturnCodeType_Ok,
	PeriodicDelayed_runtime__ReturnCodeType_EmptyQueue,
	PeriodicDelayed_runtime__ReturnCodeType_FullQueue
} PeriodicDelayed_runtime__ReturnCodeType;

#endif
