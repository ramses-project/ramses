#include "activity.h"
#include "main.h"

extern APEX_INTEGER the_proc2_p_inglobalVariable;
void* test_network_rtl8029_remote_communications_refined_model__the_proc2_the_receiver_impl_Job()
{
  while (1) {
    test_network_rtl8029_remote_communications_refined_model__the_proc2_the_receiver_entrypoint_impl (&the_proc2_p_inglobalVariable);
  }
  return 0;
}
