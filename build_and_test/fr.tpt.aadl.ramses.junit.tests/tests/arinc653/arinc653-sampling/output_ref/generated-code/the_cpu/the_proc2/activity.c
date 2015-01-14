#include "activity.h"
#include "main.h"

extern SAMPLING_PORT_ID_TYPE the_proc2_p_inglobalVariable;
void* test_sampling_refined_model__the_proc2_the_receiver_impl_Job()
{
  while (1) {
    test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl (&the_proc2_p_inglobalVariable);
  }
  return 0;
}
