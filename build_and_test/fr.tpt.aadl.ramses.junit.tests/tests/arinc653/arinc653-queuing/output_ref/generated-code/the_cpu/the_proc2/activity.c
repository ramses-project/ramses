#include "activity.h"
#include "main.h"

extern APEX_INTEGER the_proc2_p_inglobalVariable;
void* test_queuing_refined_model__the_proc2_the_receiver_impl_Job()
{
  test_queuing_refined_model__the_proc2_the_receiver_entrypoint_impl (&the_proc2_p_inglobalVariable);
  return 0;
}
