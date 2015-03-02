#include "activity.h"
#include "main.h"

void* motorTest_refined_model__proces_th_impl_Job()
{
  int motorTest_refined_model__proces_th_impl_engPort = NXT_PORT_C;
  int motorTest_refined_model__proces_th_impl_brake = 0;
  int motorTest_refined_model__proces_th_impl_speed = 100;
  while (1) {
    motorTest_refined_model__proces_th_entrypoint_impl (&motorTest_refined_model__proces_th_impl_engPort, &motorTest_refined_model__proces_th_impl_brake, &motorTest_refined_model__proces_th_impl_speed);
  }
  return 0;
}
