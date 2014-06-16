
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {"TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable","ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable","TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable",};
BLACKBOARD_ID_TYPE TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable=0;
BLACKBOARD_ID_TYPE ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable=1;
BLACKBOARD_ID_TYPE TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable=2;
SAMPLING_PORT_ID_TYPE railway_inst_EoaSending_inst_eoaForVobcOut_globalVariable;
SAMPLING_PORT_ID_TYPE railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauInglobalVariable;
SAMPLING_PORT_ID_TYPE railway_inst_TrainSimu_inst_trainDataInglobalVariable;
SAMPLING_PORT_ID_TYPE railway_inst_TrainSimu_inst_trainDataOut_globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_Init();
cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_Init();
cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_Init();
cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_impl_Init();
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_BLACKBOARD ("TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable", sizeof (cbtc_refined_model__ViuData_freshness_t_impl), &(TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable), &(ret));
  CREATE_BLACKBOARD ("ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable", sizeof (cbtc_refined_model__CdvData_freshness_t_impl), &(ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable), &(ret));
  CREATE_BLACKBOARD ("TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable", sizeof (TrainData), &(TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("railway_inst_EoaSending_inst_eoaForVobcOut",
    sizeof( cbtc_refined_model__EndOfAuthority_freshness_t_impl ), SOURCE, 10,
      &(railway_inst_EoaSending_inst_eoaForVobcOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauIn",
    sizeof( cbtc_refined_model__VobcData_freshness_t_impl ), DESTINATION, 10,
      &(railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("railway_inst_TrainSimu_inst_trainDataIn",
    sizeof( TrainData ), DESTINATION, 10,
      &(railway_inst_TrainSimu_inst_trainDataInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("railway_inst_TrainSimu_inst_trainDataOut",
    sizeof( cbtc_refined_model__TrainData_freshness_t_impl ), SOURCE, 10,
      &(railway_inst_TrainSimu_inst_trainDataOut_globalVariable), &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_Job;
  tattr.PERIOD = 600;
  tattr.DEADLINE = 600;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "TrainPositionsCorrelation_trainPositionsCorrelation");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_Job;
  tattr.PERIOD = 600;
  tattr.DEADLINE = 600;
  tattr.BASE_PRIORITY = 1;
  strcpy(tattr.NAME, "ViuTrainPositionEstimation_viuTrainPositionEstimation");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_Job;
  tattr.PERIOD = 600;
  tattr.DEADLINE = 600;
  tattr.BASE_PRIORITY = 1;
  strcpy(tattr.NAME, "TrainSimu_trainSimulation");
  CREATE_PROCESS (&(tattr), &(arinc_threads[3]), &(ret));
  START (arinc_threads[3], &(ret));
  tattr.ENTRY_POINT = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_impl_Job;
  tattr.PERIOD = 600;
  tattr.DEADLINE = 600;
  tattr.BASE_PRIORITY = 1;
  strcpy(tattr.NAME, "TrainSimu_delayed_trainDataIn");
  CREATE_PROCESS (&(tattr), &(arinc_threads[4]), &(ret));
  START (arinc_threads[4], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
