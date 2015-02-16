/*---------- Includes  ----------------------------------------------*/
#include "cbtc_mau_subsystem_Implementations_EoaSending_impl.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : EoaSending_eoaSending


/*@
  @ requires \separated(eoAInput,eoaForVobcOut);
  @ requires \valid(eoAInput);
  @ requires \valid(eoaForVobcOut);

  @ assigns (*eoaForVobcOut);

@*/



void  EoaSending_eoaSending(EndOfAuthority* eoAInput,EndOfAuthority* eoaForVobcOut){
// Start of user code EoaSending_eoaSending

  //printf("EoaSending_DefaultMode_eoaSending\n");
  
  syslog (LOG_USER | LOG_INFO, 
          "EoaSending : instance execution");

  eoaForVobcOut->ident = eoAInput->ident;
  eoaForVobcOut->limit_position = eoAInput->limit_position;

// End of user code

}



