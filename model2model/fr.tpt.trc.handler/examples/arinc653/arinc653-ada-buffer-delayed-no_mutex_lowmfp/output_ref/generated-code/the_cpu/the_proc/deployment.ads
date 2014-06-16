with Gtypes; use Gtypes;
package Deployment is
procedure Deployment;
writer_instances_the_receiver_p : test_buffer_delayed_refined_ComponentInstanceArrayDataType_the_receiver_p := (0 => (1000,1000));
context_the_receiver_p : test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p := (200,1,2,1000,writer_instances_the_receiver_p);
the_receiver_p_globalVariable : test_buffer_delayed_refined_BufferArrayType_the_receiver_p;
procedure Init_Global_Variables;
pragma Export (C, Init_Global_Variables, "Init_Global_Variables");

end Deployment;

