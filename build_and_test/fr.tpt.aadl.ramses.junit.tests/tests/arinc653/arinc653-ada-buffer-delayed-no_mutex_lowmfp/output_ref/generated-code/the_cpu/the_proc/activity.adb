
package body Activity is
  procedure test_buffer_delayed_refined_the_proc_the_sender_impl_Job is
  begin
    while TRUE loop
      test_buffer_delayed_refined_the_proc_the_sender_entrypoint_impl (the_receiver_p_globalVariable, context_the_receiver_p);
    end loop;
  end test_buffer_delayed_refined_the_proc_the_sender_impl_Job;
  procedure test_buffer_delayed_refined_the_proc_the_receiver_impl_Job is
  begin
    while TRUE loop
      test_buffer_delayed_refined_the_proc_the_receiver_entrypoint_impl (the_receiver_p_globalVariable, context_the_receiver_p);
    end loop;
  end test_buffer_delayed_refined_the_proc_the_receiver_impl_Job;
  
end Activity;

