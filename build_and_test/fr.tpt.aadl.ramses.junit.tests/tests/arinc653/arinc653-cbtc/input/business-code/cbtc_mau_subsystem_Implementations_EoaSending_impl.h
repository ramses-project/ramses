#ifndef _cbtc_mau_subsystem_Implementations_EoaSending_impl_h
#define _cbtc_mau_subsystem_Implementations_EoaSending_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_mau_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : EoaSending_eoaSending


/*@
  @ requires \separated(eoAInput,eoaForVobcOut);
  @ requires \valid(eoAInput);
  @ requires \valid(eoaForVobcOut);

  @ assigns (*eoaForVobcOut);

@*/



void  EoaSending_eoaSending(EndOfAuthority* eoAInput,EndOfAuthority* eoaForVobcOut);




#endif /* _cbtc_mau_subsystem_Implementations_EoaSending_impl_h */
