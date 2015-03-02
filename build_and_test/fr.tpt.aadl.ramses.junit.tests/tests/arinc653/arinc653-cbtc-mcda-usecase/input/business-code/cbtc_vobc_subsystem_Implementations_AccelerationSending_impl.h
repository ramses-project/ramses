#ifndef _cbtc_vobc_subsystem_Implementations_AccelerationSending_impl_h
#define _cbtc_vobc_subsystem_Implementations_AccelerationSending_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_vobc_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : AccelerationSending_accelerationSending


/*@
  @ requires \separated(trainAccelIn,tractionOut);
  @ requires \valid(trainAccelIn);
  @ requires \valid(tractionOut);

  @ assigns (*tractionOut);

@*/



void  AccelerationSending_accelerationSending(TractionData* trainAccelIn,TractionData* tractionOut);




#endif /* _cbtc_vobc_subsystem_Implementations_AccelerationSending_impl_h */
