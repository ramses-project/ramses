start_section :
    
    i : integer := 0;

	-- Task properties

	dynamic_priority : array (tasks_range) of integer;
	step : array (tasks_range) of integer;
	last_activation_tick : array (tasks_range) of integer;
	idle_time : integer := 0;

	-- Partition properties

	slot_duration  : array (tasks_range) of integer;
	slot_partition : array (tasks_range) of integer;
	slot_sliceout  : array (tasks_range) of integer; 
	
	time_slot : integer := 0;
	tick_slot : integer := 0;
	current_partition : integer :=0;
	current_slot : integer := -1;

	-- Budget definition
	
	number_of_slots : integer := <<number_of_slots>>;
	number_of_partition : integer := <<number_of_partitions>>;

	
	<<slots_duration>>
	<<slots_partition>>
	<<slots_sliceout>>
    
    -- Init tasks properties
    
	last_activation_tick := 0;
end section;

-- performed on each tick

priority_section :
  
  if ((time_slot=0) and (current_slot < number_of_slots)) then
     current_slot:=current_slot+1;
     current_partition:=slot_partition(current_slot);
     time_slot:=slot_duration(current_slot);     
  end if;
    
  if (current_slot < number_of_slots) then
	 for i in  tasks_range loop
		if (tasks.task_partition(i)=current_partition)
		then
			dynamic_priority(i) := tasks.priority(i);
			if (time_slot > slot_sliceout(current_slot))
			then
			    tasks.ready(i) := false;
			else
			    tasks.ready(i) := true;
			end if;
		else
			dynamic_priority(i) := 0;
			tasks.ready(i) := true;
		end if;
	  end loop;
	  time_slot:=time_slot-1;
  end if;
end section;



election_section :
  return max_to_index(dynamic_priority);
end section;

