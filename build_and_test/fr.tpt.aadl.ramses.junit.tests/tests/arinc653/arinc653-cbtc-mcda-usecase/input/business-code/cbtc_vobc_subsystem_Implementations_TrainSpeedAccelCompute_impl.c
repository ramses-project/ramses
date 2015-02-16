/*---------- Includes  ----------------------------------------------*/
#include "cbtc_vobc_subsystem_Implementations_TrainSpeedAccelCompute_impl.h"
#include "VobcProcessing.h"

static VobcTrainData_t self_vobc_train_data;
static long self_msg_cycle = 0;

const double MAX_TRAIN_SPEED = 100.;
const double MAX_TRAIN_ACCEL = 10;

static const uint32_t TRAIN_PPU_ID = 0;
static const uint32_t TRAINSIM_ID = 88;


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSpeedAccelCompute_trainSpeedAccelCompute


/*@
  @ requires \separated(eoaIn,trainPositionIn,trainAccelOut,trainPositionForMauOut);
  @ requires \valid(eoaIn);
  @ requires \valid(trainPositionIn);
  @ requires \valid(trainAccelOut);
  @ requires \valid(trainPositionForMauOut);

  @ assigns (*trainAccelOut);
  @ assigns (*trainPositionForMauOut);

@*/



char first=1;
void  TrainSpeedAccelCompute_trainSpeedAccelCompute(EndOfAuthority* eoaIn, VobcData* trainPositionIn,TractionData* trainAccelOut, VobcData* trainPositionForMauOut){
  // Start of user code TrainSpeedAccelCompute_trainSpeedAccelCompute
  if(first)
    {
      first = 0;
      TrainSpeedAccelCompute_trainSpeedAccelCompute_init();
    }

  //printf("TrainSpeedAccelCompute_DefaultMode_trainSpeedAccelCompute\n");

  self_vobc_train_data.distance_m = trainPositionIn->train_position_m;
  self_vobc_train_data.distance_mm = trainPositionIn->train_position_mm;
  self_vobc_train_data.speed = trainPositionIn->speed;
  self_vobc_train_data.direction = trainPositionIn->direction;

  self_vobc_train_data.limit_position = eoaIn->limit_position;

  syslog (LOG_USER | LOG_INFO, "TrainSpeedAccelCompute received from mau : train limit position %d",
          (int)eoaIn->limit_position);

  syslog (LOG_USER | LOG_INFO, "TrainSpeedAccelCompute received from vobc : train position %d, speed %d, acceleration %d\n",
          (int)trainPositionIn->train_position_m,
          (int)trainPositionIn->speed,
          (int)self_vobc_train_data.acceleration );

  // send the position and direction to mau
  trainPositionForMauOut->train_position_m = self_vobc_train_data.distance_m;
  trainPositionForMauOut->train_position_mm = self_vobc_train_data.distance_mm;
  trainPositionForMauOut->speed = self_vobc_train_data.speed;
  //trainPositionForMauOut->speed = 77;  // speed not used by mau !!
  trainPositionForMauOut->direction = self_vobc_train_data.direction;

  int32_t ret = VobcProcessing_compute_traction_data (&(self_vobc_train_data));

  if (ret != -1)
    {
      trainAccelOut->ident = 3;

      if (self_msg_cycle == 0x7FFFFFFF)
        {
          self_msg_cycle = 0;
        }
      else
        {
          self_msg_cycle++;
        }

      trainAccelOut->msg_cycle = self_msg_cycle;

      trainAccelOut->acceleration = self_vobc_train_data.acceleration;

        {
          //if (cbtc_gui.sim_ctrl_2 != 0)
          // if (cbtc_gui.get_sim_control(1) != 0)
          //   {
          //     self_vobc_train_data.acceleration += 5;
          //   }

          if ((2 * self_vobc_train_data.distance_m ) < eoaIn->limit_position)
            {
              self_vobc_train_data.acceleration += 1;
            }
          else
            {
              self_vobc_train_data.acceleration -= 1;
            }

          if( self_vobc_train_data.acceleration > MAX_TRAIN_ACCEL)
            {
              self_vobc_train_data.acceleration = MAX_TRAIN_ACCEL;
            }

          if( self_vobc_train_data.acceleration < -MAX_TRAIN_ACCEL )
            {
              self_vobc_train_data.acceleration = -MAX_TRAIN_ACCEL;
            }

          if( self_vobc_train_data.speed >= MAX_TRAIN_SPEED)
            {
              self_vobc_train_data.acceleration = 0;
            }
        }

      trainAccelOut->acceleration = self_vobc_train_data.acceleration;
      trainAccelOut->limit_position = self_vobc_train_data.limit_position;
      trainAccelOut->maxi_speed = self_vobc_train_data.maxi_speed;
      trainAccelOut->direction = self_vobc_train_data.direction;

      syslog (LOG_USER | LOG_INFO, "TrainSpeedAccelCompute send to train_ppu : acceleration %d eoa %d direction %d",
              (int)trainAccelOut->acceleration,
              (int)trainAccelOut->limit_position,
              (int)trainAccelOut->direction);
    }

  syslog (LOG_USER | LOG_INFO, "TrainSpeedAccelCompute send to mau : cycle %d, train position m %d train position mm %d speed km/h %d acceleration %d direction %d",
          (int)self_msg_cycle,
          (int)trainPositionForMauOut->train_position_m,
          (int)trainPositionForMauOut->train_position_mm,
          (int)trainPositionForMauOut->speed,
          (int)self_vobc_train_data.acceleration,
          (int)trainPositionForMauOut->direction);
// End of user code

}





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSpeedAccelCompute_trainSpeedAccelCompute_init







void  TrainSpeedAccelCompute_trainSpeedAccelCompute_init(){
// Start of user code TrainSpeedAccelCompute_trainSpeedAccelCompute_init

  self_vobc_train_data.direction        = 0;
  self_vobc_train_data.acceleration     = 0;
  self_vobc_train_data.speed            = 0;
  self_vobc_train_data.distance_m       = 0;
  self_vobc_train_data.distance_mm      = 0;
  self_vobc_train_data.prev_distance_m  = 0;
  self_vobc_train_data.prev_distance_mm = 0;
  self_vobc_train_data.limit_position   = 0;
  self_vobc_train_data.maxi_speed       = MAX_TRAIN_SPEED;
  self_vobc_train_data.stop_cycle       = 0;

// End of user code

}



