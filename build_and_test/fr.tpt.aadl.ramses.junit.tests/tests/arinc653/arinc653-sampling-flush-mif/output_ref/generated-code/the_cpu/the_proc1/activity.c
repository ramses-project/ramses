#include "activity.h"
#include "main.h"

extern SAMPLING_PORT_ID_TYPE the_proc1_p_out_globalVariable;
void test_sampling_refined_model__the_proc1_the_sender_impl_Init()
{
}

void* test_sampling_refined_model__the_proc1_the_sender_impl_Job()
{
  while (1) {
    test_sampling_refined_model__the_proc1_the_sender_entrypoint_impl (&the_proc1_p_out_globalVariable);
  }
  return 0;
}
void test_sampling_refined_model__the_proc1_error_handler_th_impl_Init()
{
}

void* test_sampling_refined_model__the_proc1_error_handler_th_impl_Job()
{
  while (1) {
    test_sampling_refined_model__the_proc1_error_handler_spg ();
  }
  return 0;
}
