#include "activity.h"
#include "main.h"

extern SAMPLING_PORT_ID_TYPE the_proc2_p_inglobalVariable;
test_sampling_refined_model__the_proc2_the_receiver_impl_BA_State_t the_proc2_the_receiver_impl_current_state = test_sampling_refined_model__the_proc2_the_receiver_impl_main_state;
void* test_sampling_refined_model__the_proc2_the_receiver_impl_Job()
{
  while(1)
{
  switch(the_proc2_the_receiver_impl_current_state)
  {
    case test_sampling_refined_model__the_proc2_the_receiver_impl_main_state:
    // Transition id: dispatch_transition
    if(1)
    {
      the_proc2_the_receiver_impl_current_state = test_sampling_refined_model__the_proc2_the_receiver_impl_main_state;
      if (1) {
      test_sampling_refined_model__the_proc2_the_receiver_entrypoint_impl (&the_proc2_p_inglobalVariable);
      }
      return;
    }
  }
}
return 0;
}
