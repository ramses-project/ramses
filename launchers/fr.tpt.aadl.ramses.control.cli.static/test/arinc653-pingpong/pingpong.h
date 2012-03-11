#ifndef __PINGPONG_H__
#define __PINGPONG_H__

typedef char * TYPE;
typedef  int SEQ;

typedef enum e_ID {
  Cping,
  Cpong
} ID;

typedef int Exception;

typedef enum e_ROLE {
  PING,
  PONG,
  UNCONNECTED
} ROLE;

typedef struct PingPongMessage {
  TYPE m_type;
  ID m_sender;
  SEQ m_seqNb;
} PingPongMessage;

void ping(PingPongMessage replyPong,
	  PingPongMessage * PingOut, 
	  Exception * badSequenceNumber,
	  SEQ * seqNb_in, 
	  SEQ * seqNb_out);

void noPing(PingPongMessage * PingOut,
	    Exception * badSequenceNumber, 
	    SEQ * seqNb);

void pong(PingPongMessage PingIn,
	  PingPongMessage * PongOut);

void storePong(PingPongMessage PongIn, 
	       PingPongMessage * replyPong);

void noPong(PingPongMessage * PongOut);

void noPingPong(PingPongMessage * PingOut,
		PingPongMessage * PongOut, 
		Exception * badSequenceNumber, 
		SEQ * seqNb);

void storeError(Exception error_in, 
		Exception * error_out);


void changeState(Exception error_in1,
		 Exception error_in2,
		 ROLE * mode_out1, 
		 ROLE * mode_out2, 
		 TYPE * state_in, 
		 TYPE * state_out);


/*
************************************************************
************************************************************
************************************************************
************************************************************
*/

typedef enum {
  PingPong__IPingOrPong_mode_switch_state,
  PingPong__IPingOrPong_mode_ret_state
} PingPong__IPingOrPong_mode_BA_State_t;


void mode(SEQ * seqNb, 
	  PingPongMessage PingIn,
	  PingPongMessage * PingOut,
	  PingPongMessage PongIn,
	  PingPongMessage * PongOut,
	  Exception * badSequenceNumber,
	  ROLE mode_aadlkeywords);

typedef enum {
  PingPong__Monitor_activate_switch_state,
  PingPong__Monitor_activate_ret_state
} PingPong__Monitor_activate_BA_State_t;


void activate(TYPE * state_bakeywords, 
	      Exception error_C1,
	      Exception error_C2,
	      ROLE * mode_C1,
	      ROLE * mode_C2);


#endif
