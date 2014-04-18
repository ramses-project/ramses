#ifndef __GENERATED_ROUTING_H__
#define __GENERATED_ROUTING_H__
#define POK_CONFIG_NB_GLOBAL_PORTS 12
#define POK_CONFIG_NB_PORTS 12
#define POK_CONFIG_NB_NODES 1
#define POK_CONFIG_PARTITIONS_PORTS {0,0,0,0,0,0,1,1,1,1,1,1,}
typedef enum
{
  root_inst = 0,
} pok_node_identifier_t;
typedef enum
{
  S1_inst_Mon_mode_C2 = 0,
  S1_inst_C1_PingOut = 1,
  S1_inst_C1_PongOut = 2,
  S1_inst_C1_PingIn = 3,
  S1_inst_C1_PongIn = 4,
  S1_inst_Mon_error_C2 = 5,
  S2_inst_C2_mode = 6,
  S2_inst_C2_PingIn = 7,
  S2_inst_C2_PongIn = 8,
  S2_inst_C2_PingOut = 9,
  S2_inst_C2_PongOut = 10,
  S2_inst_C2_badSequenceNumber = 11,
  invalid_local_port = 12
} pok_port_local_identifier_t;
typedef enum
{
  S1_inst_Mon_mode_C2_Mon_mode_C2_global = 0,
  S1_inst_C1_PingOut_C1_PingOut_global = 1,
  S1_inst_C1_PongOut_C1_PongOut_global = 2,
  S1_inst_C1_PingIn_C1_PingIn_global = 3,
  S1_inst_C1_PongIn_C1_PongIn_global = 4,
  S1_inst_Mon_error_C2_Mon_error_C2_global = 5,
  S2_inst_C2_mode_C2_mode_global = 6,
  S2_inst_C2_PingIn_C2_PingIn_global = 7,
  S2_inst_C2_PongIn_C2_PongIn_global = 8,
  S2_inst_C2_PingOut_C2_PingOut_global = 9,
  S2_inst_C2_PongOut_C2_PongOut_global = 10,
  S2_inst_C2_badSequenceNumber_C2_badSequenceNumber_global = 11,
} pok_port_identifier_t;
typedef enum
{
  invalid_bus = 0
} pok_bus_identifier_t;
#endif
