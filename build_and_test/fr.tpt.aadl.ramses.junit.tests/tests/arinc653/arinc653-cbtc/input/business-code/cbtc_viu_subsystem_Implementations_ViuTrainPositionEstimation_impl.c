/*---------- Includes  ----------------------------------------------*/
#include "cbtc_viu_subsystem_Implementations_ViuTrainPositionEstimation_impl.h"



static long self_train_position = 0;
static long self_direction = 0;


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : ViuTrainPositionEstimation_viuTrainPositionEstimation


/*@
  @ requires \separated(trackIn,trainPositionOut);
  @ requires \valid(trackIn);
  @ requires \valid(trainPositionOut);

  @ assigns (*trainPositionOut);

@*/



void  ViuTrainPositionEstimation_viuTrainPositionEstimation(CdvData* trackIn,ViuData* trainPositionOut){
// Start of user code ViuTrainPositionEstimation_viuTrainPositionEstimation

  // printf("ViuTrainPositionEstimation_DefaultMode_viuTrainPositionEstimation(ident=%d, train_pos=%d)\n",
  //        trackIn->ident, 
  //        trackIn->train_position);
  
  syslog (LOG_USER | LOG_INFO, 
          "ViuTrainPositionEstimation : instance execution");
  
  if (self_direction == 0 && (trackIn->train_position < self_train_position))
    {
      self_direction = 1;
    }
  else if (self_direction == 1 && (trackIn->train_position > self_train_position))
    {
      self_direction = 0;
    }
    
  self_train_position = trackIn->train_position;
    
  trainPositionOut->ident = 6;
  trainPositionOut->train_position = self_train_position;
  trainPositionOut->direction = self_direction;
  
// End of user code

}



