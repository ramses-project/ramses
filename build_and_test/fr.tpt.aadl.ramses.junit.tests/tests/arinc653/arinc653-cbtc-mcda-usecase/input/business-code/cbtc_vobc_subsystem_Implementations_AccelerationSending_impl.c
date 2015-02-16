/*---------- Includes  ----------------------------------------------*/
#include "cbtc_vobc_subsystem_Implementations_AccelerationSending_impl.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : AccelerationSending_accelerationSending


/*@
  @ requires \separated(trainAccelIn,tractionOut);
  @ requires \valid(trainAccelIn);
  @ requires \valid(tractionOut);

  @ assigns (*tractionOut);

@*/



void  AccelerationSending_accelerationSending(TractionData* trainAccelIn,TractionData* tractionOut){
// Start of user code AccelerationSending_accelerationSending

  //printf("AccelerationSending_DefaultMode_AccelerationSending\n");
  
  syslog (LOG_USER | LOG_INFO, "AccelerationSending : instance execution");
  
  tractionOut->ident = trainAccelIn->ident;
  tractionOut->msg_cycle = trainAccelIn->msg_cycle;
  tractionOut->acceleration = trainAccelIn->acceleration;
  tractionOut->limit_position = trainAccelIn->limit_position;
  tractionOut->maxi_speed = trainAccelIn->maxi_speed;
  tractionOut->direction = trainAccelIn->direction;
  
// End of user code

}



