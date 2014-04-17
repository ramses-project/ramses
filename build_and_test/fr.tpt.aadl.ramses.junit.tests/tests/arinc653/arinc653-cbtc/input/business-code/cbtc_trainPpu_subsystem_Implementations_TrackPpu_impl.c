/*---------- Includes  ----------------------------------------------*/
#include "cbtc_trainPpu_subsystem_Implementations_TrackPpu_impl.h"


int cycle_nb = 0;


////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrackPpu_cdvAcquisition


/*@
  @ requires \separated(trainDataIn,cdvOut);
  @ requires \valid(trainDataIn);
  @ requires \valid(cdvOut);

  @ assigns (*cdvOut);

@*/



void  TrackPpu_cdvAcquisition(TrainData* trainDataIn,CdvData* cdvOut){
// Start of user code TrackPpu_cdvAcquisition
  if(cycle_nb<10)
	printf("\n-------------- Cycle %d ------------------\n", cycle_nb);
  cycle_nb++;

  cdvOut->ident = 5;
  cdvOut->train_position = trainDataIn->distance_m;

// End of user code

}



