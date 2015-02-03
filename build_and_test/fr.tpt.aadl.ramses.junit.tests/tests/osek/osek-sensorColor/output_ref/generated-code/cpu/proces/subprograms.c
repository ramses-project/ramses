#include "ecrobot/c/ecrobot_interface.h"
#include "subprograms.h"
readColor_refined_model__proces_th_entrypoint_impl_BA_State_t proces_th_entrypoint_impl_current_state = readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_init_state;
void readColor_refined_model__proces_th_entrypoint_impl(int *  cc0_portId)
{
  StatusType readColor_refined_model__proces_th_entrypoint_impl_proces_th_runtime_call_ret;
  U16 readColor_refined_model__proces_th_entrypoint_impl_cc1_localVariable;
  readColor_refined_model__proces_th_behaviorIdentifier_enum whichPortActivated = readColor_refined_model__proces_th_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(proces_th_entrypoint_impl_current_state)
  {
    case readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      proces_th_entrypoint_impl_current_state = readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = readColor_refined_model__proces_th_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      proces_th_entrypoint_impl_current_state = readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: color -- Priority 0
    if(whichPortActivated == readColor_refined_model__proces_th_behaviorIdentifier_enum_default_behavior)
    {
      proces_th_entrypoint_impl_current_state = readColor_refined_model__proces_th_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      readColor_refined_model__proces_th_entrypoint_impl_cc1_localVariable = ecrobot_get_nxtcolorsensor_id (*cc0_portId);
      myDisplay (readColor_refined_model__proces_th_entrypoint_impl_cc1_localVariable);
      break;
    }
  }
}
}
readColor_refined_model__proces_bg_entrypoint_impl_BA_State_t proces_bg_entrypoint_impl_current_state = readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_init_state;
void readColor_refined_model__proces_bg_entrypoint_impl()
{
  StatusType readColor_refined_model__proces_bg_entrypoint_impl_proces_bg_runtime_call_ret;
  readColor_refined_model__proces_bg_behaviorIdentifier_enum whichPortActivated = readColor_refined_model__proces_bg_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(proces_bg_entrypoint_impl_current_state)
  {
    case readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      proces_bg_entrypoint_impl_current_state = readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = readColor_refined_model__proces_bg_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      proces_bg_entrypoint_impl_current_state = readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: background -- Priority 0
    if(whichPortActivated == readColor_refined_model__proces_bg_behaviorIdentifier_enum_default_behavior)
    {
      proces_bg_entrypoint_impl_current_state = readColor_refined_model__proces_bg_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      ecrobot_process_bg_nxtcolorsensor ();
      break;
    }
  }
}
}
