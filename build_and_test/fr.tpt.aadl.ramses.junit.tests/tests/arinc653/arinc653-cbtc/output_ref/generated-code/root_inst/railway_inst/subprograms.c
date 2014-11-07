#include "arinc653/sampling.h"
#include "arinc653/blackboard.h"
#include "business-code/cbtc_module.h"
#include "subprograms.h"
cbtc__TrainPositionsCorrelation_store_trainPositionMauOut_BA_State_t TrainPositionsCorrelation_store_trainPositionMauOut_current_state = cbtc__TrainPositionsCorrelation_store_trainPositionMauOut_s;
void cbtc__TrainPositionsCorrelation_store_trainPositionMauOut(TrainPosition *  delayed_trainPositionMauOut, TrainPosition *  trainPositionMauOut)
{
  while(1)
{
  switch(TrainPositionsCorrelation_store_trainPositionMauOut_current_state)
  {
    case cbtc__TrainPositionsCorrelation_store_trainPositionMauOut_s:
    // Transition id: t
    if(1) // no execution condition
    {
      TrainPositionsCorrelation_store_trainPositionMauOut_current_state = cbtc__TrainPositionsCorrelation_store_trainPositionMauOut_s;
      (*trainPositionMauOut) = (*delayed_trainPositionMauOut);
      return;
    }
  }
}
}
cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_State_t railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_init_state;
void cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl(SAMPLING_PORT_ID_TYPE *  trainPositionVobcForMauIn, BLACKBOARD_ID_TYPE *  trainPositionViuForMauIn, SAMPLING_PORT_ID_TYPE *  PortCnx7_eoaForVobcOut, cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_currentState *  Parent_BA_currentState_Access, Base_Types__Integer_16 *  trainPositionVobcForMauIn_freshnessIndicator_access, Base_Types__Integer_16 *  trainPositionViuForMauIn_freshnessIndicator_access, Base_Types__Integer_16 *  eoaForVobcOut_freshnessIndicator_access)
{
  cbtc_refined_model__VobcData_freshness_t_impl cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_Length = sizeof(cbtc_refined_model__VobcData_freshness_t_impl);
  cbtc_refined_model__ViuData_freshness_t_impl cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_Length = sizeof(cbtc_refined_model__ViuData_freshness_t_impl);
  cbtc_refined_model__EndOfAuthority_freshness_t_impl cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_eoaForVobcOut_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_eoaForVobcOut_Length = sizeof(cbtc_refined_model__EndOfAuthority_freshness_t_impl);
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_ErrorCode = 0;
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_ErrorCode = 0;
  VALIDITY_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_Validity;
  SYSTEM_TIME_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_TimeOut = 0;
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_runtime_call_ret;
  TrainPosition delayed_trainPositionMauOut;
TrainPosition trainPositionMauOut;
TrainPosition trainPositionIn;
EndOfAuthority eoAOutput;
EndOfAuthority eoAInput;
cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_behaviorIdentifier_enum whichPortActivated = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_current_state)
  {
    case cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_runtime_call_ret);
      break;
    }
    case cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: behavior_specification_1 -- Priority 0
    if(whichPortActivated == cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_behaviorIdentifier_enum_default_behavior)
    {
      railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      if ((*Parent_BA_currentState_Access) == cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_currentState_switch) {
      READ_SAMPLING_MESSAGE ((*trainPositionVobcForMauIn), &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_localVariable, cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_Length, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_Validity, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_runtime_call_ret);
      READ_BLACKBOARD ((*trainPositionViuForMauIn), cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_TimeOut, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_localVariable, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_Length, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_runtime_call_ret);
      if ((cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_localVariable.fresh_ba != (*trainPositionVobcForMauIn_freshnessIndicator_access)) && (cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_localVariable.fresh_ba != (*trainPositionViuForMauIn_freshnessIndicator_access))) {
      TrainPositionsCorrelation_trainPositionsCorrelation (&cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_localVariable.pvalue, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_localVariable.pvalue, &delayed_trainPositionMauOut);
      cbtc__TrainPositionsCorrelation_store_trainPositionMauOut (&delayed_trainPositionMauOut, &trainPositionMauOut);
      trainPositionIn = trainPositionMauOut;
      EndOfAuthorityComputation_endOfAuthorityComputation (&trainPositionIn, &eoAOutput);
      eoAInput = eoAOutput;
      EoaSending_eoaSending (&eoAInput, &(cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_eoaForVobcOut_localVariable.pvalue));
      }
      (*trainPositionVobcForMauIn_freshnessIndicator_access) = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionVobcForMauIn_localVariable.fresh_ba;
      (*trainPositionViuForMauIn_freshnessIndicator_access) = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_trainPositionViuForMauIn_localVariable.fresh_ba;
      (*eoaForVobcOut_freshnessIndicator_access) = (*eoaForVobcOut_freshnessIndicator_access) + 1;
      cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_eoaForVobcOut_localVariable.fresh_ba = (*eoaForVobcOut_freshnessIndicator_access);
      (*Parent_BA_currentState_Access) = cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_currentState_switch;
      WRITE_SAMPLING_MESSAGE ((*PortCnx7_eoaForVobcOut), &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_eoaForVobcOut_localVariable, cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_eoaForVobcOut_Length, &cbtc_refined_model__railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_entrypoint_impl_railway_inst_TrainPositionsCorrelation_trainPositionsCorrelation_runtime_call_ret);
      }
      break;
    }
  }
}
}
cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_State_t railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_init_state;
void cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl(BLACKBOARD_ID_TYPE *  trackIn, BLACKBOARD_ID_TYPE *  PortCnx1_trainPositionForMauOut, cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_currentState *  Parent_BA_currentState_Access, Base_Types__Integer_16 *  trackIn_freshnessIndicator_access, Base_Types__Integer_16 *  trainPositionForMauOut_freshnessIndicator_access)
{
  cbtc_refined_model__CdvData_freshness_t_impl cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_Length = sizeof(cbtc_refined_model__CdvData_freshness_t_impl);
  cbtc_refined_model__ViuData_freshness_t_impl cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trainPositionForMauOut_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trainPositionForMauOut_Length = sizeof(cbtc_refined_model__ViuData_freshness_t_impl);
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_ErrorCode = 0;
  SYSTEM_TIME_TYPE cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_TimeOut = 0;
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_runtime_call_ret;
  ViuData trainPositionOut;
ViuData trainPositionIn;
cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_behaviorIdentifier_enum whichPortActivated = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_current_state)
  {
    case cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_runtime_call_ret);
      break;
    }
    case cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: behavior_specification_1 -- Priority 0
    if(whichPortActivated == cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_behaviorIdentifier_enum_default_behavior)
    {
      railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      if ((*Parent_BA_currentState_Access) == cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_currentState_switch) {
      READ_BLACKBOARD ((*trackIn), cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_TimeOut, &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_localVariable, &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_Length, &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_runtime_call_ret);
      if ((cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_localVariable.fresh_ba != (*trackIn_freshnessIndicator_access))) {
      ViuTrainPositionEstimation_viuTrainPositionEstimation (&cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_localVariable.pvalue, &trainPositionOut);
      trainPositionIn = trainPositionOut;
      ViuTrainPositionSending_viuTrainPositionSending (&trainPositionIn, &(cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trainPositionForMauOut_localVariable.pvalue));
      }
      (*trackIn_freshnessIndicator_access) = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trackIn_localVariable.fresh_ba;
      (*trainPositionForMauOut_freshnessIndicator_access) = (*trainPositionForMauOut_freshnessIndicator_access) + 1;
      cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trainPositionForMauOut_localVariable.fresh_ba = (*trainPositionForMauOut_freshnessIndicator_access);
      (*Parent_BA_currentState_Access) = cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_currentState_switch;
      DISPLAY_BLACKBOARD ((*PortCnx1_trainPositionForMauOut), &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trainPositionForMauOut_localVariable, cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_trainPositionForMauOut_Length, &cbtc_refined_model__railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_entrypoint_impl_railway_inst_ViuTrainPositionEstimation_viuTrainPositionEstimation_runtime_call_ret);
      }
      break;
    }
  }
}
}
cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_State_t railway_inst_TrainSimu_trainSimulation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_init_state;
void cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl(BLACKBOARD_ID_TYPE *  delayed_trainDataIn, SAMPLING_PORT_ID_TYPE *  PortCnx6_trainDataOut, BLACKBOARD_ID_TYPE *  PortCnx3_trackOut, cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_currentState *  Parent_BA_currentState_Access, Base_Types__Integer_16 *  trainDataOut_freshnessIndicator_access, Base_Types__Integer_16 *  trackOut_freshnessIndicator_access)
{
  TrainData cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_Length = sizeof(TrainData);
  cbtc_refined_model__TrainData_freshness_t_impl cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_Length = sizeof(cbtc_refined_model__TrainData_freshness_t_impl);
  cbtc_refined_model__CdvData_freshness_t_impl cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trackOut_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trackOut_Length = sizeof(cbtc_refined_model__CdvData_freshness_t_impl);
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_ErrorCode = 0;
  SYSTEM_TIME_TYPE cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_TimeOut = 0;
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_railway_inst_TrainSimu_trainSimulation_runtime_call_ret;
  TrainData trainDataIn;
CdvData cdvOut;
CdvData cdvIn;
cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_behaviorIdentifier_enum whichPortActivated = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(railway_inst_TrainSimu_trainSimulation_entrypoint_impl_current_state)
  {
    case cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      railway_inst_TrainSimu_trainSimulation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      railway_inst_TrainSimu_trainSimulation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_railway_inst_TrainSimu_trainSimulation_runtime_call_ret);
      break;
    }
    case cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: behavior_specification_1 -- Priority 0
    if(whichPortActivated == cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_behaviorIdentifier_enum_default_behavior)
    {
      railway_inst_TrainSimu_trainSimulation_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      if ((*Parent_BA_currentState_Access) == cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_currentState_switch) {
      READ_BLACKBOARD ((*delayed_trainDataIn), cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_TimeOut, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_localVariable, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_Length, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_railway_inst_TrainSimu_trainSimulation_runtime_call_ret);
      TrainSimu_trainSimulation (&cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_delayed_trainDataIn_localVariable, &(cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_localVariable.pvalue));
      cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_localVariable.pvalue = trainDataIn;
      TrackPpu_cdvAcquisition (&trainDataIn, &cdvOut);
      cdvIn = cdvOut;
      TrackAcquisition_trackAcquisition (&cdvIn, &(cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trackOut_localVariable.pvalue));
      (*trainDataOut_freshnessIndicator_access) = (*trainDataOut_freshnessIndicator_access) + 1;
      cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_localVariable.fresh_ba = (*trainDataOut_freshnessIndicator_access);
      (*trackOut_freshnessIndicator_access) = (*trackOut_freshnessIndicator_access) + 1;
      cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trackOut_localVariable.fresh_ba = (*trackOut_freshnessIndicator_access);
      (*Parent_BA_currentState_Access) = cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_currentState_switch;
      WRITE_SAMPLING_MESSAGE ((*PortCnx6_trainDataOut), &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_localVariable, cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trainDataOut_Length, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_railway_inst_TrainSimu_trainSimulation_runtime_call_ret);
      DISPLAY_BLACKBOARD ((*PortCnx3_trackOut), &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trackOut_localVariable, cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_trackOut_Length, &cbtc_refined_model__railway_inst_TrainSimu_trainSimulation_entrypoint_impl_railway_inst_TrainSimu_trainSimulation_runtime_call_ret);
      }
      break;
    }
  }
}
}
cbtc__TrainSimu_delayed_trainDataIn_BA_State_t TrainSimu_delayed_trainDataIn_current_state = cbtc__TrainSimu_delayed_trainDataIn_s;
void cbtc__TrainSimu_delayed_trainDataIn(TrainData *  trainDataIn, TrainData *  delayed_trainDataIn)
{
  while(1)
{
  switch(TrainSimu_delayed_trainDataIn_current_state)
  {
    case cbtc__TrainSimu_delayed_trainDataIn_s:
    // Transition id: t
    if(1) // no execution condition
    {
      TrainSimu_delayed_trainDataIn_current_state = cbtc__TrainSimu_delayed_trainDataIn_s;
      (*delayed_trainDataIn) = (*trainDataIn);
      return;
    }
  }
}
}
cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_State_t railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_init_state;
void cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl(SAMPLING_PORT_ID_TYPE *  trainDataIn, BLACKBOARD_ID_TYPE *  PortCnx2_delayed_trainDataIn, cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_currentState *  Parent_BA_currentState_Access)
{
  TrainData cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_Length = sizeof(TrainData);
  TrainData cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_delayed_trainDataIn_localVariable;
  MESSAGE_SIZE_TYPE cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_delayed_trainDataIn_Length = sizeof(TrainData);
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_ErrorCode = 0;
  VALIDITY_TYPE cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_Validity;
  RETURN_CODE_TYPE cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_railway_inst_TrainSimu_delayed_trainDataIn_runtime_call_ret;
  cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_behaviorIdentifier_enum whichPortActivated = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_current_state)
  {
    case cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_exec_state;
      PERIODIC_WAIT (&cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_railway_inst_TrainSimu_delayed_trainDataIn_runtime_call_ret);
      break;
    }
    case cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: behavior_specification_1 -- Priority 0
    if(whichPortActivated == cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_behaviorIdentifier_enum_default_behavior)
    {
      railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_current_state = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      if ((*Parent_BA_currentState_Access) == cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_currentState_switch) {
      READ_SAMPLING_MESSAGE ((*trainDataIn), &cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_localVariable, cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_Length, &cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_Validity, &cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_railway_inst_TrainSimu_delayed_trainDataIn_runtime_call_ret);
      cbtc__TrainSimu_delayed_trainDataIn (&cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_trainDataIn_localVariable, &cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_delayed_trainDataIn_localVariable);
      (*Parent_BA_currentState_Access) = cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_currentState_switch;
      DISPLAY_BLACKBOARD ((*PortCnx2_delayed_trainDataIn), &cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_delayed_trainDataIn_localVariable, cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_delayed_trainDataIn_Length, &cbtc_refined_model__railway_inst_TrainSimu_delayed_trainDataIn_entrypoint_impl_railway_inst_TrainSimu_delayed_trainDataIn_runtime_call_ret);
      }
      break;
    }
  }
}
}
