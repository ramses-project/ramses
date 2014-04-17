pragma No_Run_Time;
with System; use System;
with periodicdelayed_runtime; use periodicdelayed_runtime;
with apex; use apex;
package Gtypes is
subtype Base_Types_Integer_16 is Integer;
type PeriodicDelayed_runtime_ArrayDataType is array (Integer range <>)  of Base_Types_Integer_16;
subtype test_buffer_delayed_refined_BufferArrayType_the_receiver_p is PeriodicDelayed_runtime_ArrayDataType(Integer range 0 .. 9);
  subtype Base_Types_Unsigned_16 is Integer;
type PeriodicDelayed_runtime_ComponentInstanceArrayDataType is array (Integer range <>)  of component_instance_t;
subtype test_buffer_delayed_refined_ComponentInstanceArrayDataType_the_receiver_p is PeriodicDelayed_runtime_ComponentInstanceArrayDataType(Integer range 0 .. 0);
type test_buffer_delayed_refined_periodic_delayed_context_t_impl_the_proc_the_receiver_p is record
	reader_task_period: Base_Types_Unsigned_16;
	writer_count: Base_Types_Unsigned_16;
	buffer_size: Base_Types_Unsigned_16;
	hyperperiod: Base_Types_Unsigned_16;
	writer_instances: test_buffer_delayed_refined_ComponentInstanceArrayDataType_the_receiver_p;
end record;
  subtype test_buffer_delayed_Integer is Integer;
type test_buffer_delayed_refined_the_proc_the_sender_behaviorIdentifier_enum is ( 	test_buffer_delayed_refined_the_proc_the_sender_behaviorIdentifier_enum_default_behavior
);
type test_buffer_delayed_refined_the_proc_the_receiver_behaviorIdentifier_enum is ( 	test_buffer_delayed_refined_the_proc_the_receiver_behaviorIdentifier_enum_p,
	test_buffer_delayed_refined_the_proc_the_receiver_behaviorIdentifier_enum_default_behavior
);
  procedure Gtypes;
end Gtypes;

