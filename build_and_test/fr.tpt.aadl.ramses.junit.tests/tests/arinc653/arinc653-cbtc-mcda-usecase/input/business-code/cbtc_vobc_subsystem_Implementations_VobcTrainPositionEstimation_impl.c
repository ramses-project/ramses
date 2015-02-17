/*---------- Includes  ----------------------------------------------*/
#include "cbtc_vobc_subsystem_Implementations_VobcTrainPositionEstimation_impl.h"

typedef struct
{
  /* Optionnal USER members must be put in the following section */
  /* Start of user code userCodeForVobcTrainPositionEstimation_implMembersDeclarations */
  
  int32_t  distance_m;       // m
  int32_t  distance_mm;      // mm
  int32_t  speed;            // km/h
  int32_t  direction;
  int32_t  prev_distance_m;  // m
  int32_t  prev_distance_mm; // mm
  
  //CommonData* data_region;
  
  /* End of user code userCodeForVobcTrainPositionEstimation_implMembersDeclarations */
} VobcTrainPositionEstimation_impl_t;

static const double WHEEL_DIAMETER = 1.;    // in m
static const double RADTODEG = 360./3.14;

static VobcTrainPositionEstimation_impl_t self;


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : VobcTrainPositionEstimation_vobcTrainPositionEstimation


/*@
  @ requires \separated(wheelAngleIn,delayed_additionalTrainPositionOffset,trainPositionOut);
  @ requires \valid(wheelAngleIn);
  @ requires \valid(positionOffset);
  @ requires \valid(trainPositionOut);

  @ assigns (*trainPositionOut);

@*/



void  VobcTrainPositionEstimation_vobcTrainPositionEstimation(OdometerData* wheelAngleIn, TrainPositionOffset* positionOffset,VobcData* trainPositionOut){
// Start of user code VobcTrainPositionEstimation_vobcTrainPositionEstimation

  //printf("VobcTrainPositionEstimation_DefaultMode_vobcTrainPositionEstimation\n");

  syslog (LOG_USER | LOG_INFO, 
          "VobcTrainPositionEstimation : instance execution");
  
  // check the input odometer data from ppu

  syslog (LOG_USER | LOG_INFO, "VobcTrainPositionEstimation receive from TrainPPu : angle %d speed %d", 
          (int)wheelAngleIn->wheel_angle,
          (int)wheelAngleIn->speed);
            
  trainPositionOut->ident = 2;
     
  /***
      double movement = ((double)(wheelAngleIn->wheel_angle) / RADTODEG) * WHEEL_DIAMETER;  // m
      int32_t idist_1 = (int32_t) movement;
      double dist_1 = (double) idist_1;
      double dist_2 = (movement - dist_1) * 1000.;
      int32_t idist_2 = (int32_t) dist_2;
      
      self.distance_m += idist_1;
      self.distance_mm += idist_2;
      
      
      // note : distance is always positive
      if (self.distance_mm > 1000)
      {
      self.distance_mm -= 1000;
      self.distance_m += 1;
      }
      else if (self.distance_mm < -1000)
      {
      self.distance_mm += 1000;
      self.distance_m -= 1;
      }
    
      if (self.direction == 0 && movement < -0.1)
      {
      self.direction = 1;
      }
      else if (self.direction == 1 && movement > 0.1)
      {
      self.direction = 0;
      }
  ***/
    
  self.distance_m = wheelAngleIn->wheel_angle * WHEEL_DIAMETER / RADTODEG;  // m
  self.distance_mm = 0;
    
  int32_t movement = self.distance_m - self.prev_distance_m;
    
  if (self.direction == 0 && movement < -1)
    {
      self.direction = 1;
    }
  else if (self.direction == 1 && movement > 1)
    {
      self.direction = 0;
    }

  self.prev_distance_m = self.distance_m;
  self.prev_distance_mm = self.distance_mm;
    
  self.speed = wheelAngleIn->speed;
    
  // --------------------
    
  trainPositionOut->train_position_m = self.distance_m;
  //if (sim_ctrl_1 != 0)
  //if (cbtc_gui.get_sim_control(0) != 0)
  if( *positionOffset != 0 )
    {
      trainPositionOut->train_position_m += 10;
      assert(0);
    }
  
  // trainPositionOut->train_position_mm = self.distance_mm;
  trainPositionOut->train_position_mm = 0;
  trainPositionOut->speed = self.speed;
  trainPositionOut->direction = self.direction;
    
  syslog (LOG_USER | LOG_INFO, "VobcTrainPositionEstimation send to Vobc Traction : train position %d speed %d direction %d", 
          (int)trainPositionOut->train_position_m,
          (int)trainPositionOut->speed,
          (int)trainPositionOut->direction);
            
// End of user code

}





