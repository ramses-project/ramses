/*---------- Includes  ----------------------------------------------*/
#include "cbtc_viu_subsystem_Implementations_ViuTrainPositionSending_impl.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : ViuTrainPositionSending_viuTrainPositionSending


/*@
  @ requires \separated(trainPositionIn,trainPositionForMauOut);
  @ requires \valid(trainPositionIn);
  @ requires \valid(trainPositionForMauOut);

  @ assigns (*trainPositionForMauOut);

@*/



void  ViuTrainPositionSending_viuTrainPositionSending(ViuData* trainPositionIn,ViuData* trainPositionForMauOut){
// Start of user code ViuTrainPositionSending_viuTrainPositionSending

  //printf("ViuTrainPositionSending_DefaultMode_viuTrainPositionSending\n");
  
  syslog (LOG_USER | LOG_INFO, 
          "ViuTrainPositionSending : instance execution");

  trainPositionForMauOut->ident = trainPositionIn->ident;
  trainPositionForMauOut->train_position = trainPositionIn->train_position;
  trainPositionForMauOut->direction = trainPositionIn->direction;
  
// End of user code

}



