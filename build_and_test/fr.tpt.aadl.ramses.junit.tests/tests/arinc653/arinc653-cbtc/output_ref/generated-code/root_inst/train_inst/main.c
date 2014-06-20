
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {"TrainPpu_trainTraction_tractionIn_globalVariable","VobcTrainPositionEstimation_vobcTrainPositionEstimation_additionalTrainPositionOffset_globalVariable","VobcTrainPositionEstimation_vobcTrainPositionEstimation_wheelAngleIn_globalVariable","TrainSpeedAccelCompute_trainSpeedAccelCompute_trainPositionIn_globalVariable",};
BLACKBOARD_ID_TYPE TrainPpu_trainTraction_tractionIn_globalVariable=0;
BLACKBOARD_ID_TYPE VobcTrainPositionEstimation_vobcTrainPositionEstimation_additionalTrainPositionOffset_globalVariable=1;
BLACKBOARD_ID_TYPE VobcTrainPositionEstimation_vobcTrainPositionEstimation_wheelAngleIn_globalVariable=2;
BLACKBOARD_ID_TYPE TrainSpeedAccelCompute_trainSpeedAccelCompute_trainPositionIn_globalVariable=3;
SAMPLING_PORT_ID_TYPE train_inst_TrainSpeedAccelCompute_inst_eoaInglobalVariable;
SAMPLING_PORT_ID_TYPE train_inst_TrainSpeedAccelCompute_inst_trainPositionForMauOut_globalVariable;
SAMPLING_PORT_ID_TYPE train_inst_trainPpu_inst_trainDataOut_globalVariable;
SAMPLING_PORT_ID_TYPE train_inst_trainPpu_inst_trainDataInglobalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_BLACKBOARD ("TrainPpu_trainTraction_tractionIn_globalVariable", sizeof (cbtc_refined_model__TractionData_freshness_t_impl), &(TrainPpu_trainTraction_tractionIn_globalVariable), &(ret));
  CREATE_BLACKBOARD ("VobcTrainPositionEstimation_vobcTrainPositionEstimation_additionalTrainPositionOffset_globalVariable", sizeof (TrainPositionOffset), &(VobcTrainPositionEstimation_vobcTrainPositionEstimation_additionalTrainPositionOffset_globalVariable), &(ret));
  CREATE_BLACKBOARD ("VobcTrainPositionEstimation_vobcTrainPositionEstimation_wheelAngleIn_globalVariable", sizeof (cbtc_refined_model__OdometerData_freshness_t_impl), &(VobcTrainPositionEstimation_vobcTrainPositionEstimation_wheelAngleIn_globalVariable), &(ret));
  CREATE_BLACKBOARD ("TrainSpeedAccelCompute_trainSpeedAccelCompute_trainPositionIn_globalVariable", sizeof (cbtc_refined_model__VobcData_freshness_t_impl), &(TrainSpeedAccelCompute_trainSpeedAccelCompute_trainPositionIn_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("train_inst_TrainSpeedAccelCompute_inst_eoaIn",
    sizeof( cbtc_refined_model__EndOfAuthority_freshness_t_impl ), DESTINATION, 10,
      &(train_inst_TrainSpeedAccelCompute_inst_eoaInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("train_inst_TrainSpeedAccelCompute_inst_trainPositionForMauOut",
    sizeof( cbtc_refined_model__VobcData_freshness_t_impl ), SOURCE, 10,
      &(train_inst_TrainSpeedAccelCompute_inst_trainPositionForMauOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("train_inst_trainPpu_inst_trainDataOut",
    sizeof( TrainData ), SOURCE, 10,
      &(train_inst_trainPpu_inst_trainDataOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("train_inst_trainPpu_inst_trainDataIn",
    sizeof( cbtc_refined_model__TrainData_freshness_t_impl ), DESTINATION, 10,
      &(train_inst_trainPpu_inst_trainDataInglobalVariable), &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__train_inst_TrainPpu_odometerAcquisition_impl_Job;
  tattr.PERIOD = 300;
  tattr.DEADLINE = 300;
  tattr.BASE_PRIORITY = 1;
  strcpy(tattr.NAME, "TrainPpu_odometerAcquisition");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__train_inst_TrainPpu_trainTraction_impl_Job;
  tattr.PERIOD = 300;
  tattr.DEADLINE = 300;
  tattr.BASE_PRIORITY = 1;
  strcpy(tattr.NAME, "TrainPpu_trainTraction");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__train_inst_VobcTrainPositionEstimation_vobcTrainPositionEstimation_impl_Job;
  tattr.PERIOD = 300;
  tattr.DEADLINE = 300;
  tattr.BASE_PRIORITY = 2;
  strcpy(tattr.NAME, "VobcTrainPositionEstimation_vobcTrainPositionEstimation");
  CREATE_PROCESS (&(tattr), &(arinc_threads[3]), &(ret));
  START (arinc_threads[3], &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__train_inst_TrainSpeedAccelCompute_trainSpeedAccelCompute_impl_Job;
  tattr.PERIOD = 300;
  tattr.DEADLINE = 300;
  tattr.BASE_PRIORITY = 2;
  strcpy(tattr.NAME, "TrainSpeedAccelCompute_trainSpeedAccelCompute");
  CREATE_PROCESS (&(tattr), &(arinc_threads[4]), &(ret));
  START (arinc_threads[4], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
