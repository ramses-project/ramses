#ifndef _cbtc_cbtc_subsystem_Implementations_TrainSimu_impl_h
#define _cbtc_cbtc_subsystem_Implementations_TrainSimu_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_cbtc_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSimu_trainSimulation


/*@
  @ requires \separated(delayed_trainDataIn,trainDataOut);
  @ requires \valid(delayed_trainDataIn);
  @ requires \valid(trainDataOut);

  @ assigns (*trainDataOut);

@*/



void  TrainSimu_trainSimulation(TrainData* delayed_trainDataIn,TrainData* trainDataOut);







////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSimu_trainSimulation_init







void  TrainSimu_trainSimulation_init();




#endif /* _cbtc_cbtc_subsystem_Implementations_TrainSimu_impl_h */
