/*---------- Includes  ----------------------------------------------*/
#include "cbtc_vobc_subsystem_Implementations_WheelAngleAcquisition_impl.h"





////////////////////////////////////////////////////////////////////////////////////////////
//Operation : WheelAngleAcquisition_wheelAngleAcquisition


/*@
  @ requires \separated(odometerIn,wheelAngleOut);
  @ requires \valid(odometerIn);
  @ requires \valid(wheelAngleOut);

  @ assigns (*wheelAngleOut);

@*/



void  WheelAngleAcquisition_wheelAngleAcquisition(OdometerData* odometerIn,OdometerData* wheelAngleOut){
// Start of user code WheelAngleAcquisition_wheelAngleAcquisition

  //printf("WheelAngleAcquisition_DefaultMode_wheelAngleAcquisition\n");
  
  wheelAngleOut->ident = odometerIn->ident;
  wheelAngleOut->wheel_angle = odometerIn->wheel_angle;
  wheelAngleOut->speed = odometerIn->speed;
  
// End of user code

}



