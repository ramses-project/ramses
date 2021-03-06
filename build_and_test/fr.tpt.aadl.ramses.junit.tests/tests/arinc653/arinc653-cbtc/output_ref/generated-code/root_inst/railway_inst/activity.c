#include "activity.h"
#include "main.h"

extern SAMPLING_PORT_ID_TYPE railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauInglobalVariable;
extern BLACKBOARD_ID_TYPE TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable;
extern SAMPLING_PORT_ID_TYPE railway_inst_EoaSending_inst_eoaForVobcOut_globalVariable;
extern cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_currentState TrainPositionsCorrelation_trainPositionsCorrelationParent_BA_currentState;
void* cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_Job()
{
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_trainPositionVobcForMauIn_persistentFreshnessIndicator = 0;
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_trainPositionViuForMauIn_persistentFreshnessIndicator = 0;
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_eoaForVobcOut_persistentFreshnessIndicator = 0;
  cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl (&railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauInglobalVariable, &TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable, &railway_inst_EoaSending_inst_eoaForVobcOut_globalVariable, &TrainPositionsCorrelation_trainPositionsCorrelationParent_BA_currentState, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_trainPositionVobcForMauIn_persistentFreshnessIndicator, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_trainPositionViuForMauIn_persistentFreshnessIndicator, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_impl_eoaForVobcOut_persistentFreshnessIndicator);
  return 0;
}
extern BLACKBOARD_ID_TYPE ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable;
extern BLACKBOARD_ID_TYPE TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable;
extern cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_currentState ViuTrainPositionEstimation_viuTrainPositionEstimationParent_BA_currentState;
void* cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_Job()
{
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_trackIn_persistentFreshnessIndicator = 0;
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_trainPositionForMauOut_persistentFreshnessIndicator = 0;
  cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl (&ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable, &TrainPositionsCorrelation_trainPositionsCorrelation_trainPositionViuForMauIn_globalVariable, &ViuTrainPositionEstimation_viuTrainPositionEstimationParent_BA_currentState, &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_trackIn_persistentFreshnessIndicator, &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_impl_trainPositionForMauOut_persistentFreshnessIndicator);
  return 0;
}
extern BLACKBOARD_ID_TYPE TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable;
extern SAMPLING_PORT_ID_TYPE railway_inst_TrainSimu_inst_trainDataOut_globalVariable;
extern BLACKBOARD_ID_TYPE ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable;
extern cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_currentState TrainSimu_trainSimulationParent_BA_currentState;
void* cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_Job()
{
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_trainDataOut_persistentFreshnessIndicator = 0;
  Base_Types__Integer_16 cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_trackOut_persistentFreshnessIndicator = 0;
  cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl (&TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable, &railway_inst_TrainSimu_inst_trainDataOut_globalVariable, &ViuTrainPositionEstimation_viuTrainPositionEstimation_trackIn_globalVariable, &TrainSimu_trainSimulationParent_BA_currentState, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_trainDataOut_persistentFreshnessIndicator, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_impl_trackOut_persistentFreshnessIndicator);
  return 0;
}
extern SAMPLING_PORT_ID_TYPE railway_inst_TrainSimu_inst_trainDataInglobalVariable;
extern BLACKBOARD_ID_TYPE TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable;
extern cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_currentState TrainSimu_delayed_trainDataInParent_BA_currentState;
void* cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_impl_Job()
{
  cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl (&railway_inst_TrainSimu_inst_trainDataInglobalVariable, &TrainSimu_trainSimulation_delayed_trainDataIn_globalVariable, &TrainSimu_delayed_trainDataInParent_BA_currentState);
  return 0;
}
