/*---------- Includes  ----------------------------------------------*/
#include <stdio.h>
#include "PingPong_Protocol_Implementations_Monitor_impl.h"





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

extern int i;

void  Monitor_changeState(Exception* delayed_error_C1, Exception* delayed_error_C2, ROLE* mode_C1, ROLE* mode_C2, TYPE* State_in, TYPE* State_out){
// Start of user code Monitor_changeState
  if(i>0 && i<10)
    printf("Monitor_DefaultMode_changeState( delayed_error_C1=%d, delayed_error_C2=%d, State_in=%d)\n",
         *delayed_error_C1, *delayed_error_C2, *State_in);
  
  if ( *State_in == (TYPE)E_ROLE_CPONG )
    {
      *mode_C1 = E_ROLE_CPING;
      *mode_C2 = E_ROLE_CPONG;
      *State_out = E_ROLE_CPING;
      if(i>0 && i<10)
    	printf("PING_PING_PING_PING\n");
    }
  else
    {
      *mode_C1 = E_ROLE_CPONG;
      *mode_C2 = E_ROLE_CPING;
      *State_out = E_ROLE_CPONG;
      if(i>0 && i<10)
    	printf("PONG_PONG_PONG_PONG State_in=%d, State_out=%d\n", *State_in, *State_out);
    }

  if(i>0 && i<10)
	printf("Monitor_DefaultMode_changeState( modeC1=%d, modeC2=%d, State_out=%d)\n",
         *mode_C1, *mode_C2, *State_out);
 
// End of user code

}

