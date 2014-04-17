pragma No_Run_Time;
with System;use System;
with Subprograms;use Subprograms;
with Gtypes; use Gtypes;
with Deployment; use Deployment;
package Activity is

  procedure test_buffer_delayed_refined_the_proc_the_sender_impl_Job;
  pragma Export (C,test_buffer_delayed_refined_the_proc_the_sender_impl_Job,
     "test_buffer_delayed_refined_the_proc_the_sender_impl_Job");
  
  procedure test_buffer_delayed_refined_the_proc_the_receiver_impl_Job;
  pragma Export (C,test_buffer_delayed_refined_the_proc_the_receiver_impl_Job,
     "test_buffer_delayed_refined_the_proc_the_receiver_impl_Job");
  
  
end Activity;

