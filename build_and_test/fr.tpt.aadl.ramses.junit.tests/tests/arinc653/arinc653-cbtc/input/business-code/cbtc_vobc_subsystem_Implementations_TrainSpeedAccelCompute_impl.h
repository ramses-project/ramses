#ifndef _cbtc_vobc_subsystem_Implementations_TrainSpeedAccelCompute_impl_h
#define _cbtc_vobc_subsystem_Implementations_TrainSpeedAccelCompute_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_vobc_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSpeedAccelCompute_trainSpeedAccelCompute


/*@
  @ requires \separated(eoaIn,trainPositionIn,trainAccelOut,trainPositionForMauOut);
  @ requires \valid(eoaIn);
  @ requires \valid(trainPositionIn);
  @ requires \valid(trainAccelOut);
  @ requires \valid(trainPositionForMauOut);

  @ assigns (*trainAccelOut);
  @ assigns (*trainPositionForMauOut);

@*/



void  TrainSpeedAccelCompute_trainSpeedAccelCompute(EndOfAuthority* eoaIn, VobcData* trainPositionIn,TractionData* trainAccelOut, VobcData* trainPositionForMauOut);





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSpeedAccelCompute_trainSpeedAccelCompute_init







void  TrainSpeedAccelCompute_trainSpeedAccelCompute_init();




#endif /* _cbtc_vobc_subsystem_Implementations_TrainSpeedAccelCompute_impl_h */
