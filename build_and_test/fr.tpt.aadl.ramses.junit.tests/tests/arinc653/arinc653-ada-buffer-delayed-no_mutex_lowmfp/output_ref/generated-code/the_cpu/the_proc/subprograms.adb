
package body Subprograms is
  
  procedure test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl( cnx_generated_id_0_p : in out test_buffer_delayed_refined_BufferArrayType_the_receiver_p;  p_Periodic_Delayed_ContextAccess : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p) is 
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret : RETURN_CODE_TYPE;
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_p_localVariable : test_buffer_delayed_Integer;
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_the_proc_the_sender_IterationCounter : Base_Types_Integer_16 := 0;
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_p_CDWSize : Base_Types_Integer_16 := 2;
  test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_ID : Base_Types_Integer_16 := 0;
  current_state : test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_State_t := test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
whichPortActivated : test_buffer_delayed_refined_the_proc_the_sender_behaviorIdentifier_enum;
final : integer := 0;
begin
while (final /= 1) loop
  case current_state is
    when test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state => 
    -- Transition id: which_behavior_default_mode
    if TRUE then -- no execution condition
      whichPortActivated := test_buffer_delayed_refined_the_proc_the_sender_behaviorIdentifier_enum_default_behavior;
      current_state := test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state;
    end if;
    when test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state => 
    -- Transition id: dispatch_transition
    if TRUE then -- no execution condition
      PERIODIC_WAIT (test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_the_proc_the_sender_runtime_call_ret);
      current_state := test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_init_state;
    end if;
    when test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_exec_state => 
    -- Transition id: call -- Priority 0
    if whichPortActivated = test_buffer_delayed_refined_the_proc_the_sender_behaviorIdentifier_enum_default_behavior then
      send (test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_p_localVariable);
      test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p (test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_ID, test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_the_proc_the_sender_IterationCounter, test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_p_CDWSize, test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_p_localVariable, p_Periodic_Delayed_ContextAccess, cnx_generated_id_0_p);
      PeriodicDelayed_runtime_Send_Output (test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_the_proc_the_sender_IterationCounter, test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_p_CDWSize);
      current_state := test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
    end if;
    when others =>
    final := 1;
  end case;
end loop;
end test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl;

procedure test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl( p : in out test_buffer_delayed_refined_BufferArrayType_the_receiver_p;  p_Periodic_Delayed_ContextAccess : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p) is 
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret : RETURN_CODE_TYPE;
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_localVariable : test_buffer_delayed_Integer;
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_IterationCounter : Base_Types_Integer_16 := 0;
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_CPRSize : Base_Types_Integer_16 := 10;
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_lastIndex : Base_Types_Integer_16 := -1;
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_readIndex : Base_Types_Integer_16 := -1;
  test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_the_receiver_p_BufferSize : Base_Types_Integer_16 := 2;
  current_state : test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_State_t := test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
whichPortActivated : test_buffer_delayed_refined_the_proc_the_receiver_behaviorIdentifier_enum;
final : integer := 0;
begin
while (final /= 1) loop
  case current_state is
    when test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state => 
    -- Transition id: which_behavior_default_mode
    if TRUE then -- no execution condition
      whichPortActivated := test_buffer_delayed_refined_the_proc_the_receiver_behaviorIdentifier_enum_default_behavior;
      current_state := test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state;
    end if;
    when test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state => 
    -- Transition id: dispatch_transition
    if TRUE then -- no execution condition
      PERIODIC_WAIT (test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_runtime_call_ret);
      current_state := test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_init_state;
    end if;
    when test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_exec_state => 
    -- Transition id: call -- Priority 0
    if whichPortActivated = test_buffer_delayed_refined_the_proc_the_receiver_behaviorIdentifier_enum_default_behavior then
      test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p (test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_the_proc_the_receiver_IterationCounter, test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_CPRSize, p_Periodic_Delayed_ContextAccess, test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_readIndex, test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_lastIndex);
      test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p (test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_readIndex, test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_lastIndex, p, test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_localVariable, test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_the_receiver_p_BufferSize);
      receive (test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_p_localVariable);
      current_state := test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl_BA_entrypoint_wait_dispatch_state;
    end if;
    when others =>
    final := 1;
  end case;
end loop;
end test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl;
procedure Last_Chance_Handler (Source_Location : System.Address; Line : Integer) is
 pragma Unreferenced (Source_Location, Line);
begin
loop
null;
end loop;
end Last_Chance_Handler;

procedure test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p( taskID : in Base_Types_Integer_16;  iteration_counter : in out Base_Types_Integer_16;  CDWSize : in Base_Types_Integer_16;  value : in test_buffer_delayed_Integer;  periodic_delayed_context : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p;  buffer : out test_buffer_delayed_refined_BufferArrayType_the_receiver_p) is 
  current_state : test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p_BA_State_t := test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p_s;
CDWIndex : Base_Types_Integer_16;
final : integer := 0;
begin
while (final /= 1) loop
  case current_state is
    when test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p_s => 
    -- Transition id: t
    if TRUE then -- no execution condition
      Compute_CDW (taskID, iteration_counter, periodic_delayed_context, CDWIndex);
      buffer(CDWIndex) := value;
      final := 1;
    end if;
    when others =>
    final := 1;
  end case;
end loop;
end test_buffer_delayed_refined_Put_Value_LowFP_the_proc_the_sender_p;

procedure PeriodicDelayed_runtime_Send_Output( iteration_counter : in out Base_Types_Integer_16;  CDWSize : in Base_Types_Integer_16) is 
  current_state : PeriodicDelayed_runtime_Send_Output_BA_State_t := PeriodicDelayed_runtime_Send_Output_s;
final : integer := 0;
begin
while (final /= 1) loop
  case current_state is
    when PeriodicDelayed_runtime_Send_Output_s => 
    -- Transition id: t
    if TRUE then -- no execution condition
      iteration_counter := (iteration_counter + 1) mod CDWSize;
      final := 1;
    end if;
    when others =>
    final := 1;
  end case;
end loop;
end PeriodicDelayed_runtime_Send_Output;

procedure test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p( iteration_counter : in out Base_Types_Integer_16;  CPRSize : in Base_Types_Integer_16;  periodic_delayed_context : in out test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p;  first : in out Base_Types_Integer_16;  last : in out Base_Types_Integer_16) is 
  current_state : test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p_BA_State_t := test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p_s;
final : integer := 0;
begin
while (final /= 1) loop
  case current_state is
    when test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p_s => 
    -- Transition id: t
    if TRUE then -- no execution condition
      Compute_CPR (iteration_counter, periodic_delayed_context, first);
      iteration_counter := (iteration_counter + 1) mod CPRSize;
      Compute_CPR (iteration_counter, periodic_delayed_context, last);
      final := 1;
    end if;
    when others =>
    final := 1;
  end case;
end loop;
end test_buffer_delayed_refined_Receive_Input_LowFP_the_proc_the_receiver_p;

procedure test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p( first : in out Base_Types_Integer_16;  last : in Base_Types_Integer_16;  buffer : in test_buffer_delayed_refined_BufferArrayType_the_receiver_p;  output : out test_buffer_delayed_Integer;  bufferSize : in Base_Types_Integer_16) is 
  current_state : test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p_BA_State_t := test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p_s;
final : integer := 0;
begin
while (final /= 1) loop
  case current_state is
    when test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p_s => 
    -- Transition id: t
    if TRUE then -- no execution condition
      if (first >= 0)  then
      output := buffer(first);
      if (first /= last)  then
      first := (first + 1) mod bufferSize;
      
      end if;
      
      end if;
      final := 1;
    end if;
    when others =>
    final := 1;
  end case;
end loop;
end test_buffer_delayed_refined_Next_Value_the_proc_the_receiver_p;

end Subprograms;

