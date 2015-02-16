#ifndef _cbtc_viu_subsystem_Implementations_TrackAcquisition_impl_h
#define _cbtc_viu_subsystem_Implementations_TrackAcquisition_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_viu_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrackAcquisition_trackAcquisition


/*@
  @ requires \separated(cdvIn,trackOut);
  @ requires \valid(cdvIn);
  @ requires \valid(trackOut);

  @ assigns (*trackOut);

@*/



void  TrackAcquisition_trackAcquisition(CdvData* cdvIn,CdvData* trackOut);




#endif /* _cbtc_viu_subsystem_Implementations_TrackAcquisition_impl_h */
