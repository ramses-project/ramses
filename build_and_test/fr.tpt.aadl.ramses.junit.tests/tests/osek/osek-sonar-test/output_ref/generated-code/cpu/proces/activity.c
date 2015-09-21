#include "activity.h"
#include "main.h"

void* sonarTest_refined_model__proces_th_impl_Job()
{
  int sonarTest_refined_model__proces_th_impl_batPort = NXT_PORT_S4;
  sonarTest_refined_model__proces_th_entrypoint_impl (&sonarTest_refined_model__proces_th_impl_batPort);
  return 0;
}
