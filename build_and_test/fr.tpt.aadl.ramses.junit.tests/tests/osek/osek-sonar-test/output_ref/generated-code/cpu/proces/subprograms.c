#include "ecrobot/c/ecrobot_interface.h"
#include "subprograms.h"
sonarTest_refined_model__proces_th_entrypoint_impl_BA_State_t proces_th_entrypoint_impl_current_state = sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_init_state;
void sonarTest_refined_model__proces_th_entrypoint_impl(int *  cc5_portNb)
{
  StatusType sonarTest_refined_model__proces_th_entrypoint_impl_proces_th_runtime_call_ret;
  S32 sonarTest_refined_model__proces_th_entrypoint_impl_cc6_localVariable;
  sonarTest_refined_model__proces_th_behaviorIdentifier_enum whichPortActivated = sonarTest_refined_model__proces_th_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(proces_th_entrypoint_impl_current_state)
  {
    case sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      proces_th_entrypoint_impl_current_state = sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = sonarTest_refined_model__proces_th_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      proces_th_entrypoint_impl_current_state = sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call1 -- Priority 0
    if(whichPortActivated == sonarTest_refined_model__proces_th_behaviorIdentifier_enum_default_behavior)
    {
      proces_th_entrypoint_impl_current_state = sonarTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      sonarTest_refined_model__proces_th_entrypoint_impl_cc6_localVariable = ecrobot_get_sonar_sensor (*cc5_portNb);
      show (sonarTest_refined_model__proces_th_entrypoint_impl_cc6_localVariable);
      break;
    }
  }
}
}
