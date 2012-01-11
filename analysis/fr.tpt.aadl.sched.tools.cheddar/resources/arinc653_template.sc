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
	
	available_time_per_instant : array (time_units_range) of integer;
	next_idle_per_instant : array (time_units_range) of integer;
	slot_per_instant : array (time_units_range) of integer;
	
	time_slot : integer := 0;
	tick_slot : integer := 0;
	elapsed_idle : integer := 0;
	next_idle_time : integer := 0;
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
     
     -- compute elapsed idle time of this partition
     elapsed_idle := 0;
     i := current_slot-1;
     while (i >= 0) loop
       if (not (slot_partition(i) = current_partition)) 
       then
          elapsed_idle := elapsed_idle + slot_duration(i);
       end if;
       i:=i-1;
     end loop;
     
     -- compute idle time from now to next partition window
     next_idle_time := 0;
     i := current_slot+1;
     while ((i < number_of_slots) and not(slot_partition(i) = current_partition)) loop
       next_idle_time := next_idle_time + slot_duration(i);
       i:=i+1;
     end loop;
  end if;
  
  available_time_per_instant(simulation_time) := time_slot;
  next_idle_per_instant(simulation_time) := next_idle_time;
  slot_per_instant(simulation_time) := current_slot;

    if (current_slot < number_of_slots) then
	  for i in  tasks_range loop
		if (tasks.task_partition(i)=current_partition)
		then
			last_activation_tick(i) := (tasks.period(i) * (tasks.activation_number(i)-1)) + elapsed_idle;
			tick_slot := slot_per_instant(last_activation_tick(i));
			
			if (not (slot_partition(tick_slot) = current_partition)) then
			   last_activation_tick(i) := last_activation_tick(i) - elapsed_idle;
			end if;
			
			if (tasks.period(i) >= available_time_per_instant(last_activation_tick(i))) then
			   step(i) := tasks.period(i) + next_idle_per_instant(last_activation_tick(i));
			else
			   step(i) := tasks.period(i);
			end if;
			
			dynamic_priority(i) := tasks.priority(i);
			if (time_slot > slot_sliceout(current_slot))
			then
				tasks.suspended(i) := false;
			else
			    tasks.suspended(i) := true;
			end if;
		else
			dynamic_priority(i) := 0;
			tasks.suspended(i) := true;
		end if;
	  end loop;
	  time_slot:=time_slot-1;
  end if;
end section;



election_section :
  return max_to_index(dynamic_priority);
end section;



-- performed on each task activation

task_activation_section :
  set arinc653_periodic step;
end section;