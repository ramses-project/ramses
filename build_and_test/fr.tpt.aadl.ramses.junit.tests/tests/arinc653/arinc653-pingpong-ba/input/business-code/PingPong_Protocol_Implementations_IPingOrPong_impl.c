/*---------- Includes  ----------------------------------------------*/
#include <stdio.h>
#include "PingPong_Protocol_Implementations_IPingOrPong_impl.h"




////////////////////////////////////////////////////////////////////////////////////////////
//Operation : IPingOrPong_PINGping


/*@
  @ requires \separated(delayed_PongIn,seqNb_in,PingOut,badSequenceNumber,seqNb_out);
  @ requires \valid(delayed_PongIn);
  @ requires \valid(seqNb_in);
  @ requires \valid(PingOut);
  @ requires \valid(badSequenceNumber);
  @ requires \valid(seqNb_out);

  @ assigns (*PingOut);
  @ assigns (*badSequenceNumber);
  @ assigns (*seqNb_out);

  @ behavior normal:
  @   assumes(((*delayed_PongIn).m_seqNb == (*seqNb_in)));
  @   ensures((*seqNb_out) == ((*seqNb_in) + 1));
  @   ensures((*PingOut).m_seqNb == ((*seqNb_in) + 1));
  @   ensures(((*badSequenceNumber) == 0));

  @ behavior exceptional:
  @   assumes((*delayed_PongIn).m_seqNb != (*seqNb_in));
  @   ensures((*badSequenceNumber) == 1);

@*/

int i=0;
void  IPingOrPong_Cping_ping(PingPongMessage* delayed_PongIn, PingPongMessage* PingOut, Exception* badSequenceNumber, SEQ* seqNb_in, SEQ* seqNb_out){
// Start of user code IPingOrPong_Cping_ping

  if( delayed_PongIn->m_seqNb == *seqNb_in ) // behavior normal
    {
      *seqNb_out = *seqNb_in + 1;
      PingOut->m_seqNb = *seqNb_out;
      *badSequenceNumber = 0;
    }
  else // behavior exceptional
    {
      *badSequenceNumber = 1;
    }
  if(i>0 && i<10)
	printf("PING( seqIN=%d, seqOUT=%d, PING=%d )\n", *seqNb_in, *seqNb_out, PingOut->m_seqNb );
  i++;
 
// End of user code

}

////////////////////////////////////////////////////////////////////////////////////////////
//Operation : IPingOrPong_PONGpong


/*@
  @ requires \separated(PingIn,PongOut);
  @ requires \valid(PingIn);
  @ requires \valid(PongOut);

  @ assigns (*PongOut);

  @ behavior normal:
  @   ensures((*PongOut).m_seqNb == (*PingIn).m_seqNb);

@*/


void  IPingOrPong_Cpong_pong(PingPongMessage* PingIn,PingPongMessage* PongOut){
// Start of user code IPingOrPong_Cpong_pong
  PongOut->m_seqNb = PingIn->m_seqNb;
  if(i>0 && i<10)
	printf("PONG( seqIN = seqOUT = PONG = %d )\n", PongOut->m_seqNb);
  i++;
// End of user code

}
