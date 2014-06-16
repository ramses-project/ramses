/*---------- Includes  ----------------------------------------------*/
#include "cbtc_trainPpu_subsystem_Implementations_TrainPpu_impl.h"


static const uint32_t TRAIN_PPU_ID = 0;

static const double ONE_MILLE = 1000.;
static const double WHEEL_DIAMETER = 1.;    // in m
static const double RADTODEG = 360./3.14;

// static const double emerg_braking_coef = 10;    // dm/sec2

// static const bool is_valid_traction_data = true;


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainPpu_odometerAcquisition


/*@
  @ requires \separated(trainDataIn,odometerOut);
  @ requires \valid(trainDataIn);
  @ requires \valid(odometerOut);

  @ assigns (*odometerOut);

@*/



void  TrainPpu_odometerAcquisition(TrainData* trainDataIn,OdometerData* odometerOut){
// Start of user code TrainPpu_odometerAcquisition

  //printf("TrainPpu_DefaultMode_odometerAcquisition\n");

  int32_t abs_angle = trainDataIn->distance_m * RADTODEG / WHEEL_DIAMETER;    // in deg

  odometerOut->ident = 1;
  // odometerOut->wheel_angle = (int32_t) angle;  // deg
  odometerOut->wheel_angle = abs_angle;           // deg
  odometerOut->speed = trainDataIn->speed;               // km/h

  syslog (LOG_USER | LOG_INFO, "TrainPpu send to Vobc Pos : wheel_angle %d speed %d",
          (int)odometerOut->wheel_angle,
          (int)odometerOut->speed);

// End of user code

}





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainPpu_trainTraction


/*@
  @ requires \separated(tractionIn,trainDataIn,additionalTrainPositionOffset,trainDataOut);
  @ requires \valid(tractionIn);
  @ requires \valid(trainDataIn);
  @ requires \valid(additionalTrainPositionOffset);
  @ requires \valid(trainDataOut);

  @ assigns (*additionalTrainPositionOffset);
  @ assigns (*trainDataOut);

@*/



void  TrainPpu_trainTraction(TractionData* tractionIn, TrainData* trainDataIn,TrainPositionOffset* additionalTrainPositionOffset, TrainData* trainDataOut){
// Start of user code TrainPpu_trainTraction

  //printf("TrainPpu_DefaultMode_trainTraction\n");

  syslog (LOG_USER | LOG_INFO, "TrainPpu tractionIn : cycle %d, acceleration dm/sec2 %d, limit_position m = %d, maxi_speed %d, direction m = %d",
          (int)tractionIn->msg_cycle,
          (int)tractionIn->acceleration,
          (int)tractionIn->limit_position,
          (int)tractionIn->maxi_speed,
          (int)tractionIn->direction);

  /****
  // compute train movement (can be negative)
  double movement = (double) (trainDataFromSimuIn->distance_m - self_prev_distance_m);  // m
  movement = movement + (double) (trainDataFromSimuIn->distance_mm - self_prev_distance_mm) / ONE_MILLE;

  double angle = (movement / WHEEL_DIAMETER) * RADTODEG;    // in deg

  self_prev_distance_m = trainDataFromSimuIn->distance_m;
  self_prev_distance_mm = trainDataFromSimuIn->distance_mm;
  ****/

  // check if the input traction data from vobc is valid
  // if (is_valid_traction_data == false)
  // {
  //   syslog (LOG_USER | LOG_ERR, "TrainPpu : TractionData are invalid !!!");
  //   // set emergency braking
  //   trainDataOut->acceleration = -emerg_braking_coef;
  // }
  // else
  // {
    // trainDataOut->msg_cycle = tractionIn->msg_cycle;
  trainDataOut->acceleration = tractionIn->acceleration;
  trainDataOut->limit_position = tractionIn->limit_position;
  trainDataOut->maxi_speed = tractionIn->maxi_speed;
  trainDataOut->direction = tractionIn->direction;
  // }
  
  if (trainDataIn->msg_cycle == 0x7FFFFFFF)
  {
    trainDataOut->msg_cycle = 0;
  }
  else
  {
    trainDataOut->msg_cycle = trainDataIn->msg_cycle + 1;
  }

  // create train data with direction and acceleration/breaking and publish to simulation
  trainDataOut->source_ident = TRAIN_PPU_ID;
  trainDataOut->destination_ident = 88;
  trainDataOut->speed = trainDataIn->speed;
  trainDataOut->distance_m = trainDataIn->distance_m;
  trainDataOut->distance_mm = trainDataIn->distance_mm;
  trainDataOut->computing_element = trainDataIn->computing_element;

  *additionalTrainPositionOffset = trainDataIn->sim_ctrl_1;

  syslog (LOG_USER | LOG_INFO, "TrainPpu send : cycle %d, acceleration dm/sec2 %d, limit_position m = %d, additionalTrainPositionOffset = %d",
          (int)trainDataOut->msg_cycle,
          (int)trainDataOut->acceleration,
          (int)trainDataOut->limit_position,
          (int)*additionalTrainPositionOffset);

// End of user code

}



