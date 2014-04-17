#ifndef __GENERATED_ROUTING_H__
#define __GENERATED_ROUTING_H__
#define POK_CONFIG_NB_GLOBAL_PORTS 2
#define POK_CONFIG_NB_PORTS 2
#define POK_CONFIG_NB_NODES 1
#define POK_CONFIG_PARTITIONS_PORTS {0,1,}
typedef enum
{
  the_cpu = 0,
} pok_node_identifier_t;
typedef enum
{
  the_proc1_p_out = 0,
  the_proc2_p_in = 1,
  invalid_local_port = 2
} pok_port_local_identifier_t;
typedef enum
{
  the_proc1_p_out_p_out_global = 0,
  the_proc2_p_in_p_in_global = 1,
} pok_port_identifier_t;
typedef enum
{
  invalid_bus = 0
} pok_bus_identifier_t;
#endif
