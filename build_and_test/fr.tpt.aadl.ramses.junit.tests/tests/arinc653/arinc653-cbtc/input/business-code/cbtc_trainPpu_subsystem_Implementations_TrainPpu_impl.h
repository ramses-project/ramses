#ifndef _cbtc_trainPpu_subsystem_Implementations_TrainPpu_impl_h
#define _cbtc_trainPpu_subsystem_Implementations_TrainPpu_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_trainPpu_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainPpu_odometerAcquisition


/*@
  @ requires \separated(trainDataIn,odometerOut);
  @ requires \valid(trainDataIn);
  @ requires \valid(odometerOut);

  @ assigns (*odometerOut);

@*/



void  TrainPpu_odometerAcquisition(TrainData* trainDataIn,OdometerData* odometerOut);





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainPpu_trainTraction


/*@
  @ requires \separated(tractionIn,trainDataIn,additionalTrainPositionOffset,trainDataOut);
  @ requires \valid(tractionIn);
  @ requires \valid(trainDataIn);
  @ requires \valid(additionalTrainPositionOffset);
  @ requires \valid(trainDataOut);

  @ assigns (*additionalTrainPositionOffset);
  @ assigns (*trainDataOut);

@*/



void  TrainPpu_trainTraction(TractionData* tractionIn, TrainData* trainDataIn,TrainPositionOffset* additionalTrainPositionOffset, TrainData* trainDataOut);




#endif /* _cbtc_trainPpu_subsystem_Implementations_TrainPpu_impl_h */
