#include "pingpong.h"
#include <stdio.h>

#include "pingpong.h"
#include <stdio.h>

int d = 1;

void ping(PingPongMessage replyPong,
	  PingPongMessage * PingOut, 
	  Exception * badSequenceNumber,
	  SEQ * seqNb_in, 
	  SEQ * seqNb_out) 
{
  d++;
  if(d<10 && d>1)
    printf("In ping: current value = %d, received answer = %d\n", *seqNb_in, replyPong.m_seqNb);
  if(replyPong.m_seqNb == *seqNb_in)
    {
      *seqNb_out = (*seqNb_in)+1;
      PingOut->m_type = "Bonjour";
      PingOut->m_sender = Cping;
      PingOut->m_seqNb = *seqNb_out % 5;
      *badSequenceNumber=0;
      if(d<10 && d>1)
        printf("In ping: OK!\n");
    }
  else
    {
      *badSequenceNumber=1;
      *seqNb_out=0;
      PingOut->m_seqNb=0;
      if(d<10 && d>1)
        printf("In ping: NOK!\n");
    }
}

void pong(PingPongMessage PingIn,
	  PingPongMessage * PongOut)
{
  PongOut->m_type = "Bonsoir";
  PongOut->m_sender = Cpong;
  PongOut->m_seqNb = PingIn.m_seqNb;
  d++;
  if(d<10 && d>1)
    printf("In pong, returned value = %d\n", PongOut->m_seqNb);
}

int first = 1;
void changeState(Exception error_in1,
		 Exception error_in2,
		 ROLE * mode_out1, 
		 ROLE * mode_out2, 
		 TYPE* state_in, 
		 TYPE * state_out)
{
  if(first==1)
    {
      *mode_out1 = PING;
      *mode_out2 = PONG;
      *state_in = "Initialization";
    }
  else
    {
      *state_in = "Nominal";
      if(error_in1)
	{
	  ROLE to_switch = *mode_out2;
	  *mode_out2 = *mode_out1;
	  *mode_out1 = to_switch;
	  *state_in = "Switch";
	}
      else if(error_in2)
	{
	  ROLE to_switch = *mode_out1;
	  *mode_out1 = *mode_out2;
	  *mode_out2 = to_switch;
	  *state_in = "Switch";
	}
    }
  if(d<10 && d>1)
    printf("In changeState: %s\n",*state_in);
}

void noPing(PingPongMessage * PingOut,
	    Exception * badSequenceNumber, 
	    SEQ * seqNb)
{  
  //printf("In noPing\n");
}

void storePong(PingPongMessage PongIn, 
	       PingPongMessage * replyPong)
{
  replyPong->m_type = PongIn.m_type;
  replyPong->m_sender = PongIn.m_sender;
  replyPong->m_seqNb = PongIn.m_seqNb;
  // printf("In storePong, %d\n", PongIn.m_seqNb);
}

void noPong(PingPongMessage * PongOut)
{
  //  printf("In noPong\n");
}

void noPingPong(PingPongMessage * PingOut,
		PingPongMessage * PongOut, 
		Exception * badSequenceNumber, 
		SEQ * seqNb)
{
  //  printf("In noPingPong\n");
}

void storeError(Exception error_in, 
		Exception * error_out)
{
  //  *error_out=error_in;
  //  printf("In storeError\n");
}

/*
************************************************************
************************************************************
************************************************************
************************************************************
*/

int fresh=0;
ROLE prev=UNCONNECTED;
void mode(SEQ * seqNb, 
	  PingPongMessage PingIn,
	  PingPongMessage * PingOut,
	  PingPongMessage PongIn,
	  PingPongMessage * PongOut,
	  Exception * badSequenceNumber,
	  ROLE mode_aadlKeywords)
{
  PingPong__IPingOrPong_mode_BA_State_t current_state = PingPong__IPingOrPong_mode_switch_state;
  PingPongMessage replyPong;
  if(prev!=mode_aadlKeywords)
    {
      *seqNb=0;
      first=0;
      prev=mode_aadlKeywords;
      replyPong.m_seqNb=0;
      *badSequenceNumber=0;
    }
  char final = 0;
  while(final != 1)
    {
      switch(current_state)
	{
	case PingPong__IPingOrPong_mode_switch_state:
	  if(mode_aadlKeywords == PING)
	    {
	      
	      storePong(PongIn, &replyPong);
	      if(fresh==1) ping(replyPong, PingOut, badSequenceNumber, seqNb, seqNb);
	      noPong(PongOut);
	      
	      current_state = PingPong__IPingOrPong_mode_ret_state;
	      final = 1;
	      fresh = 1;
	      break;
	    }
	  if(mode_aadlKeywords == PONG)
	    {
	      fresh=0;
	      pong(PingIn, PongOut);
	      noPing(PingOut, badSequenceNumber, seqNb);

	      current_state = PingPong__IPingOrPong_mode_ret_state;
	      final = 1;
	      break;
	    }
	  if(mode_aadlKeywords == UNCONNECTED)
	    {
	      noPingPong(PingOut, PongOut, badSequenceNumber, seqNb);
	      current_state = PingPong__IPingOrPong_mode_ret_state;
	      final = 1;
	      break;
	    }
	}
    }
}


void activate(TYPE * state_baKeywords, 
	      Exception error_C1,
	      Exception error_C2,
	      ROLE * mode_C1,
	      ROLE * mode_C2)
{
  PingPong__Monitor_activate_BA_State_t current_state = PingPong__Monitor_activate_switch_state;

  char final = 0;
  while(final != 1)
    {
      switch(current_state)
	{
	case PingPong__Monitor_activate_switch_state:
	  if(1)
	    {
	      
	      //	      storeError(error_C1, error_C1);
	      //	      storeError(error_C2, error_C2);
	      changeState(error_C1, error_C2, mode_C1, mode_C2, state_baKeywords, state_baKeywords);
	      current_state = PingPong__Monitor_activate_ret_state;
	      final = 1;
	      break;
	    }
	}
    }
}
