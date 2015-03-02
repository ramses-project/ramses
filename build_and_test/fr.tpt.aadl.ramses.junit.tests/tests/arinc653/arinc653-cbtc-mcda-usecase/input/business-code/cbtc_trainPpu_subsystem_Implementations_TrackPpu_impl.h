#ifndef _cbtc_trainPpu_subsystem_Implementations_TrackPpu_impl_h
#define _cbtc_trainPpu_subsystem_Implementations_TrackPpu_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_trainPpu_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrackPpu_cdvAcquisition


/*@
  @ requires \separated(trainDataIn,cdvOut);
  @ requires \valid(trainDataIn);
  @ requires \valid(cdvOut);

  @ assigns (*cdvOut);

@*/



void  TrackPpu_cdvAcquisition(TrainData* trainDataIn,CdvData* cdvOut);




#endif /* _cbtc_trainPpu_subsystem_Implementations_TrackPpu_impl_h */
