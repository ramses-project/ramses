/*---------- Includes  ----------------------------------------------*/
#include "cbtc_mau_subsystem_Implementations_TrainPositionsCorrelation_impl.h"

const int32_t max_diff_position = 1;
const int32_t max_change_position = 10;

static int32_t self_vobc_status = 1;
static int32_t self_viu_status = 1;
static int32_t self_train_position = 0;       // m
static int32_t self_train_direction = 0;


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainPositionsCorrelation_trainPositionsCorrelation


/*@
  @ requires \separated(trainPositionVobcForMauIn,trainPositionViuForMauIn,delayed_trainPositionMauOut);
  @ requires \valid(trainPositionVobcForMauIn);
  @ requires \valid(trainPositionViuForMauIn);
  @ requires \valid(delayed_trainPositionMauOut);

  @ assigns (*delayed_trainPositionMauOut);

@*/



void  TrainPositionsCorrelation_trainPositionsCorrelation(VobcData* trainPositionVobcForMauIn, ViuData* trainPositionViuForMauIn,TrainPosition* delayed_trainPositionMauOut){
// Start of user code TrainPositionsCorrelation_trainPositionsCorrelation

  // printf("TrainPositionsCorrelation_DefaultMode_trainPositionsCorrelation( pos_from_vobc=%d, pos_from_viu=%d)\n", 
  //        trainPositionVobcForMauIn->train_position_m,
  //        trainPositionViuForMauIn->train_position);
  
  syslog (LOG_USER | LOG_INFO, 
          "TrainPositionsCorrelation : instance execution");
  
  syslog (LOG_USER | LOG_INFO, "TrainPositionsCorrelation receive from vobc : train position %d", 
          (int)trainPositionVobcForMauIn->train_position_m);

  //*****    viu not installed

  syslog (LOG_USER | LOG_INFO, "TrainPositionsCorrelation receive from viu : train position %d", 
          (int)trainPositionViuForMauIn->train_position);

  //******/
  
  int32_t curr_train_position;
  int32_t curr_train_direction;
  int32_t position_valid = 1;

  // check vobc
  self_vobc_status = 1;
  
    {
      int32_t delta_pos_vobc = trainPositionVobcForMauIn->train_position_m - self_train_position; // m 
    
      // if vobc has too much difference between previous cycle
      if (delta_pos_vobc > max_change_position ||
          delta_pos_vobc < -max_change_position)
        {
          // set faulty vobc
          self_vobc_status = 0;
        }
    }
     
  // viu is not installed
  self_viu_status = 0;
    
  /*****    viu not installed
   // check viu
  
   viu_status = 1;
  
   if (ret_viu == 1)
   {
   int32_t delta_pos_viu = trainPositionViuForMauIn->train_position - self_train_position; // m 
          
   // if viu has too much difference between previous cycle
   if (delta_pos_viu > max_change_position ||
   delta_pos_viu < -max_change_position)
   {
   // set faulty viu
   viu_status = 0;
   }
   }
  ******/
    
  // if vobc and viu are ok
  if (self_vobc_status == 1 && self_viu_status == 1)
    {
      // diff between vobc and viu
      int32_t delta_pos = 
        trainPositionVobcForMauIn->train_position_m - 
        trainPositionViuForMauIn->train_position; // m
    
      if (delta_pos > max_diff_position ||
          delta_pos < -max_diff_position)
        {
          syslog (LOG_USER | LOG_ERR, "TrainPositionsCorrelation : difference between vobc and viu %d", delta_pos);
        }
      
      curr_train_position = (trainPositionVobcForMauIn->train_position_m + 
                             trainPositionViuForMauIn->train_position) / 2;
      curr_train_direction = trainPositionVobcForMauIn->direction;
    }
  else  if (self_vobc_status == 1)
    {
      curr_train_position = trainPositionVobcForMauIn->train_position_m;
      curr_train_direction = trainPositionVobcForMauIn->direction;
    }
  else  if (self_viu_status == 1)
    {
      curr_train_position = trainPositionViuForMauIn->train_position;
      curr_train_direction = trainPositionViuForMauIn->direction;
    }
  else
    {
      position_valid = 0;
    }

  if (position_valid == 1)
    {
      self_train_position = curr_train_position;
      self_train_direction = curr_train_direction;

      delayed_trainPositionMauOut->train_position = curr_train_position;
      delayed_trainPositionMauOut->train_direction = curr_train_direction;

      /* eoa_compute->set_train_position(self_train_position,  */
      /*                                 self_train_direction); */
    }
  else
    {
      printf("CBTC Invalid position\n");
      assert(0);
    }
  
// End of user code

}





