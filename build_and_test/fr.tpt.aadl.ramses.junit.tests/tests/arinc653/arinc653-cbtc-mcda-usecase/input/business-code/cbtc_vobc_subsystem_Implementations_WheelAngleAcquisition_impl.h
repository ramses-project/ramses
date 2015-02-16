#ifndef _cbtc_vobc_subsystem_Implementations_WheelAngleAcquisition_impl_h
#define _cbtc_vobc_subsystem_Implementations_WheelAngleAcquisition_impl_h

/*---------- Includes  ----------------------------------------------*/
#include "cbtc_module.h"
#include "cbtc_vobc_subsystem_Implementations_module.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : WheelAngleAcquisition_wheelAngleAcquisition


/*@
  @ requires \separated(odometerIn,wheelAngleOut);
  @ requires \valid(odometerIn);
  @ requires \valid(wheelAngleOut);

  @ assigns (*wheelAngleOut);

@*/



void  WheelAngleAcquisition_wheelAngleAcquisition(OdometerData* odometerIn,OdometerData* wheelAngleOut);




#endif /* _cbtc_vobc_subsystem_Implementations_WheelAngleAcquisition_impl_h */
