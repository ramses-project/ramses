#include "activity.h"
#include "main.h"

extern APEX_INTEGER the_proc1_p_out_globalVariable;
void* test_queuing_refined_model__the_proc1_the_sender_impl_Job()
{
  while (1) {
    test_queuing_refined_model__the_proc1_the_sender_entrypoint_impl (&the_proc1_p_out_globalVariable);
  }
  return 0;
}
