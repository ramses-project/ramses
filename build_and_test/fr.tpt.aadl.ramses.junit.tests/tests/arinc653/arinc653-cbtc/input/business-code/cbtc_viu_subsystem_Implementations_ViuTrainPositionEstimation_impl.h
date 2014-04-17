#ifndef _cbtc_viu_subsystem_Implementations_ViuTrainPositionEstimation_impl_h
#define _cbtc_viu_subsystem_Implementations_ViuTrainPositionEstimation_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_viu_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : ViuTrainPositionEstimation_viuTrainPositionEstimation


/*@
  @ requires \separated(trackIn,trainPositionOut);
  @ requires \valid(trackIn);
  @ requires \valid(trainPositionOut);

  @ assigns (*trainPositionOut);

@*/



void  ViuTrainPositionEstimation_viuTrainPositionEstimation(CdvData* trackIn,ViuData* trainPositionOut);




#endif /* _cbtc_viu_subsystem_Implementations_ViuTrainPositionEstimation_impl_h */
