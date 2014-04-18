#ifndef _PingPong_Protocol_Implementations_IPingOrPong_impl_h
#define _PingPong_Protocol_Implementations_IPingOrPong_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "PingPong_module.h"
#include "PingPong_Protocol_Implementations_module.h"






////////////////////////////////////////////////////////////////////////////////////////////
//Operation : IPingOrPong_Cpingping


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


void  IPingOrPong_Cping_ping(PingPongMessage* delayed_PongIn, PingPongMessage* PingOut, Exception* badSequenceNumber, SEQ* seqNb_in, SEQ* seqNb_out);







////////////////////////////////////////////////////////////////////////////////////////////
//Operation : IPingOrPong_Cpongpong


/*@
  @ requires \separated(PingIn,PongOut);
  @ requires \valid(PingIn);
  @ requires \valid(PongOut);

  @ assigns (*PongOut);

  @ behavior normal:
  @   ensures((*PongOut).m_seqNb == (*PingIn).m_seqNb);

@*/



void  IPingOrPong_Cpong_pong(PingPongMessage* PingIn,PingPongMessage* PongOut);



#endif /* _PingPong_Protocol_Implementations_IPingOrPong_impl_h */
