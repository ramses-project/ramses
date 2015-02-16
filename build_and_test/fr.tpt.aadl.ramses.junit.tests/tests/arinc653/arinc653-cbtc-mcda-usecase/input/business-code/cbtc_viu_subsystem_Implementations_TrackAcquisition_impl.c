/*---------- Includes  ----------------------------------------------*/
#include "cbtc_viu_subsystem_Implementations_TrackAcquisition_impl.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrackAcquisition_trackAcquisition


/*@
  @ requires \separated(cdvIn,trackOut);
  @ requires \valid(cdvIn);
  @ requires \valid(trackOut);

  @ assigns (*trackOut);

@*/



void  TrackAcquisition_trackAcquisition(CdvData* cdvIn,CdvData* trackOut){
// Start of user code TrackAcquisition_trackAcquisition

  // printf("TrackAcquisition_DefaultMode_trackAcquisition(ident=%d, train_pos=%d)\n",
  //        cdvIn->ident, 
  //        cdvIn->train_position );
  
  trackOut->ident = cdvIn->ident;
  trackOut->train_position = cdvIn->train_position;
  
// End of user code

}



