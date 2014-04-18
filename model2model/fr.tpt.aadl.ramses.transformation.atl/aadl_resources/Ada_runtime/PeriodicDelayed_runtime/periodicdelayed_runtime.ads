package PeriodicDelayed_runtime is

type Component_Instance_T is record
	period: Integer;
	deadline: Integer;
end record;

--type component_instances_array_t is Array (Integer range <>) of component_instance_t;

--type periodic_delayed_context_t (L: Integer) is record
--  reader_task_period: Integer; 	-- reader task period
--  writer_instances: Component_Instances_Array_T (0..L-1); -- writer tasks data
--  writer_count: Integer; -- writer tasks number
--  buffer_size: Integer;
--  hyperperiod: Integer;
--end record;

end PeriodicDelayed_runtime;
