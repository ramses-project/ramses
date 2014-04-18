#ifndef _PingPong_Protocol_Implementations_Monitor_impl_h
#define _PingPong_Protocol_Implementations_Monitor_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "PingPong_module.h"
#include "PingPong_Protocol_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : Monitor_changeState


/*@
  @ requires \separated(delayed_error_C1,delayed_error_C2,State_in,mode_C1,mode_C2,State_out);
  @ requires \valid(delayed_error_C1);
  @ requires \valid(delayed_error_C2);
  @ requires \valid(State_in);
  @ requires \valid(mode_C1);
  @ requires \valid(mode_C2);
  @ requires \valid(State_out);

  @ assigns (*mode_C1);
  @ assigns (*mode_C2);
  @ assigns (*State_out);

  @ behavior normal:
  @   ensures((*mode_C1) != (*mode_C2));

@*/


void  Monitor_changeState(Exception* delayed_error_C1, Exception* delayed_error_C2, ROLE* mode_C1, ROLE* mode_C2, TYPE* State_in, TYPE* State_out);







#endif /* _PingPong_Protocol_Implementations_Monitor_impl_h */
