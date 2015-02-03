#include "nxt_motors.h"
#include "ecrobot/c/ecrobot_interface.h"
#include "subprograms.h"
motorTest_refined_model__proces_th_entrypoint_impl_BA_State_t proces_th_entrypoint_impl_current_state = motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_init_state;
void motorTest_refined_model__proces_th_entrypoint_impl(int *  cc5_portNb, int *  cc6_brake, int *  cc7_speed)
{
  StatusType motorTest_refined_model__proces_th_entrypoint_impl_proces_th_runtime_call_ret;
  motorTest_refined_model__proces_th_behaviorIdentifier_enum whichPortActivated = motorTest_refined_model__proces_th_behaviorIdentifier_enum_default_behavior;
while(1)
{
  switch(proces_th_entrypoint_impl_current_state)
  {
    case motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_init_state:
    // Transition id: which_behavior_default_mode
    if(1) // no execution condition
    {
      proces_th_entrypoint_impl_current_state = motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state;
      whichPortActivated = motorTest_refined_model__proces_th_behaviorIdentifier_enum_default_behavior;
      break;
    }
    case motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_wait_dispatch_state:
    // Transition id: dispatch_transition
    if(1) // no execution condition
    {
      proces_th_entrypoint_impl_current_state = motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state;
      TerminateTask ();
      break;
    }
    case motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_exec_state:
    // Transition id: call1 -- Priority 0
    if(whichPortActivated == motorTest_refined_model__proces_th_behaviorIdentifier_enum_default_behavior)
    {
      proces_th_entrypoint_impl_current_state = motorTest_refined_model__proces_th_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
      nxt_motor_set_speed (*cc5_portNb, *cc7_speed, *cc6_brake);
      break;
    }
  }
}
}
