#ifndef _cbtc_viu_subsystem_Implementations_ViuTrainPositionSending_impl_h
#define _cbtc_viu_subsystem_Implementations_ViuTrainPositionSending_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_viu_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : ViuTrainPositionSending_viuTrainPositionSending


/*@
  @ requires \separated(trainPositionIn,trainPositionForMauOut);
  @ requires \valid(trainPositionIn);
  @ requires \valid(trainPositionForMauOut);

  @ assigns (*trainPositionForMauOut);

@*/



void  ViuTrainPositionSending_viuTrainPositionSending(ViuData* trainPositionIn,ViuData* trainPositionForMauOut);




#endif /* _cbtc_viu_subsystem_Implementations_ViuTrainPositionSending_impl_h */
