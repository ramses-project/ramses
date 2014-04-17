with apex.timing; use apex.timing;
with Interfaces.C; use Interfaces.C;
with apex; use apex;
with Gtypes; use Gtypes;
with System; use System;
package Subprograms is
procedure test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl( cnx_generated_id_0_p : in out test_buffer_delayed_refined_BufferArrayType_the_receiver_p;  p_Periodic_Delayed_ContextAccess : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p);
  
  type test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_State_t is (
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state,
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state,
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_final_state
);

procedure test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl( p : in out test_buffer_delayed_refined_BufferArrayType_the_receiver_p;  p_Periodic_Delayed_ContextAccess : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p);
  
  type test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_State_t is (
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state,
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state,
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_final_state
);

procedure Last_Chance_Handler (Source_Location :System.Address; Line : Integer);
pragma Export (C, Last_Chance_Handler,"__gnat_last_chance_handler");
procedure send( result : out test_buffer_delayed_Integer);

pragma Import (C, send,"send");
procedure test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p( taskID : in Base_Types_Integer_16;  iteration_counter : in out Base_Types_Integer_16;  CDWSize : in Base_Types_Integer_16;  value : in test_buffer_delayed_Integer;  periodic_delayed_context : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p;  buffer : out test_buffer_delayed_refined_BufferArrayType_the_receiver_p);

type test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p_BA_State_t is (
  test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p_s
);

procedure Compute_CDW( taskID : in Base_Types_Integer_16;  iteration_counter : in Base_Types_Integer_16;  periodic_delayed_context : in test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p;  CDW : out Base_Types_Integer_16);

pragma Import (C, Compute_CDW,"Compute_CDW");
procedure PeriodicDelayed_runtime_Send_Output( iteration_counter : in out Base_Types_Integer_16;  CDWSize : in Base_Types_Integer_16);

type PeriodicDelayed_runtime_Send_Output_BA_State_t is (
  PeriodicDelayed_runtime_Send_Output_s
);

procedure test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p( iteration_counter : in out Base_Types_Integer_16;  CPRSize : in Base_Types_Integer_16;  periodic_delayed_context : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p;  first : in out Base_Types_Integer_16;  last : in out Base_Types_Integer_16);

type test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p_BA_State_t is (
  test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p_s
);

procedure Compute_CPR( iteration_counter : in Base_Types_Integer_16;  periodic_delayed_context : in test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p;  CPR : out Base_Types_Integer_16);

pragma Import (C, Compute_CPR,"Compute_CPR");
procedure test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p( first : in out Base_Types_Integer_16;  last : in Base_Types_Integer_16;  buffer : in test_buffer_delayed_refined_BufferArrayType_the_receiver_p;  output : out test_buffer_delayed_Integer;  bufferSize : in Base_Types_Integer_16);

type test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p_BA_State_t is (
  test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p_s
);

procedure receive( input : in test_buffer_delayed_Integer);

pragma Import (C, receive,"receive");

end Subprograms;

