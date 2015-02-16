#ifndef _cbtc_vobc_subsystem_Implementations_VobcTrainPositionEstimation_impl_h
#define _cbtc_vobc_subsystem_Implementations_VobcTrainPositionEstimation_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_vobc_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : VobcTrainPositionEstimation_vobcTrainPositionEstimation


/*@
  @ requires \separated(wheelAngleIn,delayed_additionalTrainPositionOffset,trainPositionOut);
  @ requires \valid(wheelAngleIn);
  @ requires \valid(delayed_additionalTrainPositionOffset);
  @ requires \valid(trainPositionOut);

  @ assigns (*trainPositionOut);

@*/



void  VobcTrainPositionEstimation_vobcTrainPositionEstimation(OdometerData* wheelAngleIn, TrainPositionOffset* delayed_additionalTrainPositionOffset,VobcData* trainPositionOut);






#endif /* _cbtc_vobc_subsystem_Implementations_VobcTrainPositionEstimation_impl_h */
