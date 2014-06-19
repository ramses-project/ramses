#ifndef __GENERATED_ROUTING_H__
#define __GENERATED_ROUTING_H__
#define POK_CONFIG_NB_GLOBAL_PORTS 6
#define POK_CONFIG_NB_PORTS 3
#define POK_CONFIG_NB_NODES 2
#define POK_CONFIG_PARTITIONS_PORTS {0,1,0,}
typedef enum
{
  the_cpu1 = 0,
  the_cpu2 = 1,
} pok_node_identifier_t;
typedef enum
{
  the_cpu1_system_part_comProcess_the_proc1_p_out = 0,
  the_proc1_p_out = 1,
  the_proc1_p_out_virtual_port = 2,
  invalid_local_port = 3
} pok_port_local_identifier_t;
typedef enum
{
  the_cpu1_system_part_comProcess_the_proc1_p_out_the_proc1_p_out_global = 0,
  the_cpu2_system_part_comProcess_the_proc2_p_in_the_proc2_p_in_global = 1,
  the_proc1_p_out_p_out_global = 2,
  the_proc2_p_in_p_in_global = 3,
  the_proc1_p_out_p_out_global_virtual_port = 4,
  the_proc2_p_in_p_in_global_virtual_port = 5,
} pok_port_identifier_t;
typedef enum
{
  the_bus = 0,
  invalid_bus = 1
} pok_bus_identifier_t;
#endif
