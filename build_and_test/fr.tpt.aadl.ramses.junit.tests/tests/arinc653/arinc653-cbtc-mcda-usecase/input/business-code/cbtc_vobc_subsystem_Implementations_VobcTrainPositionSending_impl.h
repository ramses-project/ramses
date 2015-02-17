#ifndef _cbtc_vobc_subsystem_Implementations_VobcTrainPositionSending_impl_h
#define _cbtc_vobc_subsystem_Implementations_VobcTrainPositionSending_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_vobc_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : VobcTrainPositionSending_vobcTrainPositionSending


/*@
  @ requires \separated(trainPositionIn,trainPositionOut);
  @ requires \valid(trainPositionIn);
  @ requires \valid(trainPositionOut);

  @ assigns (*trainPositionOut);

@*/



void  VobcTrainPositionSending_vobcTrainPositionSending(VobcData* trainPositionIn,VobcData* trainPositionOut);




#endif /* _cbtc_vobc_subsystem_Implementations_VobcTrainPositionSending_impl_h */
