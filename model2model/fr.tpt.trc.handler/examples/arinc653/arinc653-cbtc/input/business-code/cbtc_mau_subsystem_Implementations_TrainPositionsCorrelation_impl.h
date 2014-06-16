#ifndef _cbtc_mau_subsystem_Implementations_TrainPositionsCorrelation_impl_h
#define _cbtc_mau_subsystem_Implementations_TrainPositionsCorrelation_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_mau_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainPositionsCorrelation_trainPositionsCorrelation


/*@
  @ requires \separated(trainPositionVobcForMauIn,trainPositionViuForMauIn,delayed_trainPositionMauOut);
  @ requires \valid(trainPositionVobcForMauIn);
  @ requires \valid(trainPositionViuForMauIn);
  @ requires \valid(delayed_trainPositionMauOut);

  @ assigns (*delayed_trainPositionMauOut);

@*/



void  TrainPositionsCorrelation_trainPositionsCorrelation(VobcData* trainPositionVobcForMauIn, ViuData* trainPositionViuForMauIn,TrainPosition* delayed_trainPositionMauOut);






#endif /* _cbtc_mau_subsystem_Implementations_TrainPositionsCorrelation_impl_h */
