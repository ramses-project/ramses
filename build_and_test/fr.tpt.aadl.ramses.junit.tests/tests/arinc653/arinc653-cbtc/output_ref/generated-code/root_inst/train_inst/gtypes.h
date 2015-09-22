#ifndef __GENERATED_GTYPES_H__
#define __GENERATED_GTYPES_H__
#include "arinc653/sampling.h"
#include "business-code/cbtc_module.h"
#include "arinc653/blackboard.h"
#include "arinc653/types.h"
typedef signed int Base_Types__Integer_16;
typedef SAMPLING_PORT_ID_TYPE arinc653_runtime__Sampling_Port_Id_Type;
typedef BLACKBOARD_ID_TYPE arinc653_runtime__Blackboard_Id_Type;
typedef enum e_cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_currentState {
	cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_currentState_switch
} cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_currentState;
typedef struct cbtc_refined_model__TrainData_freshness_t_impl {
	TrainData pvalue;
	Base_Types__Integer_16 fresh_ba;
} cbtc_refined_model__TrainData_freshness_t_impl;
typedef MESSAGE_SIZE_TYPE arinc653_runtime__Message_Size_Type;
typedef struct cbtc_refined_model__OdometerData_freshness_t_impl {
	OdometerData pvalue;
	Base_Types__Integer_16 fresh_ba;
} cbtc_refined_model__OdometerData_freshness_t_impl;
typedef RETURN_CODE_TYPE arinc653_runtime__Return_Code_Type;
typedef VALIDITY_TYPE arinc653_runtime__Validity_Type;
typedef enum e_cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_behaviorIdentifier_enum {
	cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_behaviorIdentifier_enum_default_behavior,
	cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_behaviorIdentifier_enum_trainDataIn
} cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_behaviorIdentifier_enum;
typedef enum e_cbtc_refined_model__train_inst_TrainPpu_trainTraction_currentState {
	cbtc_refined_model__train_inst_TrainPpu_trainTraction_currentState_switch
} cbtc_refined_model__train_inst_TrainPpu_trainTraction_currentState;
typedef struct cbtc_refined_model__TractionData_freshness_t_impl {
	TractionData pvalue;
	Base_Types__Integer_16 fresh_ba;
} cbtc_refined_model__TractionData_freshness_t_impl;
typedef signed int COAL__long;
typedef TrainPositionOffset cbtc__TrainPositionOffset;
typedef struct cbtc__TrainData {
} cbtc__TrainData;
typedef SYSTEM_TIME_TYPE arinc653_runtime__System_Time_Type;
typedef enum e_cbtc_refined_model__train_inst_TrainPpu_trainTraction_behaviorIdentifier_enum {
	cbtc_refined_model__train_inst_TrainPpu_trainTraction_behaviorIdentifier_enum_default_behavior,
	cbtc_refined_model__train_inst_TrainPpu_trainTraction_behaviorIdentifier_enum_tractionIn,
	cbtc_refined_model__train_inst_TrainPpu_trainTraction_behaviorIdentifier_enum_trainDataIn
} cbtc_refined_model__train_inst_TrainPpu_trainTraction_behaviorIdentifier_enum;
typedef enum e_cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_currentState {
	cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_currentState_switch
} cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_currentState;
typedef struct cbtc_refined_model__VobcData_freshness_t_impl {
	VobcData pvalue;
	Base_Types__Integer_16 fresh_ba;
} cbtc_refined_model__VobcData_freshness_t_impl;
typedef enum e_cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_behaviorIdentifier_enum {
	cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_behaviorIdentifier_enum_default_behavior,
	cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_behaviorIdentifier_enum_additionalTrainPositionOffset,
	cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_behaviorIdentifier_enum_wheelAngleIn
} cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_behaviorIdentifier_enum;
typedef enum e_cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_currentState {
	cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_currentState_switch
} cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_currentState;
typedef struct cbtc_refined_model__EndOfAuthority_freshness_t_impl {
	EndOfAuthority pvalue;
	Base_Types__Integer_16 fresh_ba;
} cbtc_refined_model__EndOfAuthority_freshness_t_impl;
typedef enum e_cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_behaviorIdentifier_enum {
	cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_behaviorIdentifier_enum_default_behavior,
	cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_behaviorIdentifier_enum_eoaIn,
	cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_behaviorIdentifier_enum_trainPositionIn
} cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_behaviorIdentifier_enum;

#endif

