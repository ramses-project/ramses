/*---------- Includes  ----------------------------------------------*/
#include "cbtc_vobc_subsystem_Implementations_VobcTrainPositionSending_impl.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : VobcTrainPositionSending_vobcTrainPositionSending


/*@
  @ requires \separated(trainPositionIn,trainPositionOut);
  @ requires \valid(trainPositionIn);
  @ requires \valid(trainPositionOut);

  @ assigns (*trainPositionOut);

@*/



void  VobcTrainPositionSending_vobcTrainPositionSending(VobcData* trainPositionIn,VobcData* trainPositionOut){
// Start of user code VobcTrainPositionSending_vobcTrainPositionSending

  //printf("VobcTrainPositionSending_DefaultMode_vobcTrainPositionSending\n");
  
  syslog (LOG_USER | LOG_INFO, 
          "VobcTrainPositionSending : instance execution");
  
  trainPositionOut->ident = trainPositionIn->ident;
  trainPositionOut->train_position_m = trainPositionIn->train_position_m;
  trainPositionOut->train_position_mm = trainPositionIn->train_position_mm;
  trainPositionOut->direction = trainPositionIn->direction;
  trainPositionOut->speed = trainPositionIn->speed;
  
// End of user code

}



