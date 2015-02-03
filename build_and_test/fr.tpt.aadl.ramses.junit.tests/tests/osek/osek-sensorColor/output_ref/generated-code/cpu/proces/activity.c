#include "activity.h"
#include "main.h"

void* readColor_refined_model__proces_th_impl_Job()
{
  int readColor_refined_model__proces_th_impl_colorPortNb = NXT_PORT_S2;
  while (1) {
    readColor_refined_model__proces_th_entrypoint_impl (&readColor_refined_model__proces_th_impl_colorPortNb);
  }
  return 0;
}
void* readColor_refined_model__proces_bg_impl_Job()
{
  while (1) {
    readColor_refined_model__proces_bg_entrypoint_impl ();
  }
  return 0;
}
