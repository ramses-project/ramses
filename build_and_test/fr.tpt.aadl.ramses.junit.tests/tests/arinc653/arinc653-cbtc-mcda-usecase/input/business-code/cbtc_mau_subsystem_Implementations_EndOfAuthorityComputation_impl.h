#ifndef _cbtc_mau_subsystem_Implementations_EndOfAuthorityComputation_impl_h
#define _cbtc_mau_subsystem_Implementations_EndOfAuthorityComputation_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_mau_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : EndOfAuthorityComputation_endOfAuthorityComputation


/*@
  @ requires \separated(trainPositionIn,eoAOutput);
  @ requires \valid(trainPositionIn);
  @ requires \valid(eoAOutput);

  @ assigns (*eoAOutput);

@*/



void  EndOfAuthorityComputation_endOfAuthorityComputation(TrainPosition* trainPositionIn,EndOfAuthority* eoAOutput);




#endif /* _cbtc_mau_subsystem_Implementations_EndOfAuthorityComputation_impl_h */
