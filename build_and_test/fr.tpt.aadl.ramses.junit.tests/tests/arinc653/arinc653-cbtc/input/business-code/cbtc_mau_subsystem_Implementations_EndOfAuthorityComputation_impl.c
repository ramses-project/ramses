/*---------- Includes  ----------------------------------------------*/
#include "cbtc_mau_subsystem_Implementations_EndOfAuthorityComputation_impl.h"

#include "Tools.h"

// definition of the scenario
// according to the current position of the train
// the distance of the previous train before is given
// according to the scenario set


/****

#define MAX_ZONE 21

const int32_t train_dist_tab [MAX_ZONE] =
               {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};  //km
               
const int32_t gap_dist_tab [MAX_ZONE] =
//               0    05   10  15   20   25   30   35   40   45   50   55   60   65   70   75   80   85   90   95   100
               {100, 100, 100, 50,  30,  15,  2,   1,   20,  50,  100, 100, 100, 100, 50,  30,  5,   1,   10,  30,  0};  //hm
               
const int32_t gap_dist_reverse_tab [MAX_ZONE] =
//               0    05   10  15   20   25   30   35   40   45   50   55   60   65   70   75   80   85   90   95   100
               {0,   100, 100, 50,  30,  15,  1,   2,   20,  50,  100, 100, 100, 100, 50,  30,  1,   5,   10,  30,  100};  //hm
****/

#define MAX_ZONE 26

const int32_t train_dist_tab [MAX_ZONE] =
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};  //km
               
const int32_t gap_dist_tab [MAX_ZONE] =
//              0   01  02  03  04  05 06 07 08 09 10 11  12  13  14  15  16  17  18  19  20  21  22  23  24  25
               {25, 25, 25, 25, 12, 7, 4, 1, 1, 1, 5, 12, 25, 25, 25, 25, 25, 12, 9,  7,  1,  1,  2,  5,  7,  0};  //hm
               
const int32_t gap_dist_reverse_tab [MAX_ZONE] =
//              0   01  02  03  04  05 06 07 08 09 10 11  12  13  14  15  16  17  18  19  20  21  22  23  24  25
               {0,  25, 25, 17, 10, 7, 4, 1, 1, 2, 5, 12, 25, 25, 25, 25, 25, 12, 9,  7,  1,  2,  3,  5,  7,  25};  //hm               


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : EndOfAuthorityComputation_endOfAuthorityComputation


/*@
  @ requires \separated(trainPositionIn,eoAOutput);
  @ requires \valid(trainPositionIn);
  @ requires \valid(eoAOutput);

  @ assigns (*eoAOutput);

@*/



void  EndOfAuthorityComputation_endOfAuthorityComputation(TrainPosition* trainPositionIn,EndOfAuthority* eoAOutput){
// Start of user code EndOfAuthorityComputation_endOfAuthorityComputation

  //printf("EndOfAuthorityComputation_DefaultMode_endOfAuthorityComputation( size(int)==%d, size(eoAOutput)==%d )\n", sizeof(int), sizeof(EndOfAuthority));
  assert(eoAOutput != NULL);

  // begin check train_direction domain value
  //assert((trainPositionIn->train_direction == 0)||(trainPositionIn->train_direction == 1)); 
  if((trainPositionIn->train_direction != 0)&&(trainPositionIn->train_direction != 1))
    {
      trainPositionIn->train_direction = 0;
      printf("CBTC WARNING EndOfAuthorityComputation_DefaultMode_endOfAuthorityComputation: reset train_direction !!!\n");
    }
  // end check train_direction domain value
  
  //int32_t ret = 0;
  
  // syslog (LOG_USER | LOG_INFO, 
  //        "EndOfAuthorityComputation : train_position %d direction %d",
  //        train_position, direction);
  
  // get the eoaOutput data receptacle from context
  //CCM_TAS_mau_EndOfAuthority_Sender_ptr data_sender = self->context->eoAOutput_data;
  
  // get the end of authority
  //mau_EndOfAuthority eoAOutput;
  
  eoAOutput->ident = 4;
  
  const int32_t* train_gap_tab;
  
  if (trainPositionIn->train_direction == 0)
  {
    train_gap_tab = gap_dist_tab;
  }
  else
  {
    train_gap_tab = gap_dist_reverse_tab;
  }
  
  int32_t train_gap = get_tabvalue (train_dist_tab, train_gap_tab, 
                                    MAX_ZONE, trainPositionIn->train_position/1000);  // hm

  if (trainPositionIn->train_direction == 0)
  {
    eoAOutput->limit_position = trainPositionIn->train_position + train_gap*100;
  }
  else
  {
    eoAOutput->limit_position = trainPositionIn->train_position - train_gap*100;
  }
  
  // syslog (LOG_USER | LOG_INFO, 
  //         "EndOfAuthorityComputation : train_gap %d eoAOutput.limit_position %d",
  //         train_gap, eoAOutput.limit_position);

  //ret = data_sender->send(&eoAOutput);
      
  // if (ret == -1)
  // {
  //   syslog (LOG_USER | LOG_ERR, "EndOfAuthorityComputation : send() EndOfAuthority failed, %d", ret);
  // }
  
// End of user code

}



