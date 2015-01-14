#include "routing.h"
#include "middleware/port.h"
#include <types.h>
uint8_t the_cpu2_system_part_comProcess_partport[2] = {the_cpu2_system_part_comProcess_the_proc2_p_in,the_proc2_p_in_virtual_port,};
uint8_t the_cpu2_system_part_comProcess_the_proc2_p_in_deployment_destinations[1] = {the_proc2_p_in_p_in_global,};
uint8_t the_proc2_partport[1] = {the_proc2_p_in,};
uint8_t pok_global_ports_to_local_ports[POK_CONFIG_NB_GLOBAL_PORTS] = {invalid_local_port,the_cpu2_system_part_comProcess_the_proc2_p_in,invalid_local_port,the_proc2_p_in,invalid_local_port,the_proc2_p_in_virtual_port,};
uint8_t pok_global_ports_to_bus[POK_CONFIG_NB_GLOBAL_PORTS] = {invalid_bus,invalid_bus,invalid_bus,invalid_bus,the_bus,the_bus,};
uint8_t pok_local_ports_to_global_ports[POK_CONFIG_NB_PORTS] = {the_cpu2_system_part_comProcess_the_proc2_p_in_the_proc2_p_in_global,the_proc2_p_in_p_in_global,the_proc2_p_in_p_in_global_virtual_port,};
uint8_t pok_ports_nodes[POK_CONFIG_NB_GLOBAL_PORTS] = {the_cpu1,the_cpu2,the_cpu1,the_cpu2,the_cpu1,the_cpu2,};
uint8_t pok_ports_nb_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {2,1,};
uint8_t* pok_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {the_cpu2_system_part_comProcess_partport,the_proc2_partport,};
char* pok_ports_names[POK_CONFIG_NB_PORTS] = {"the_cpu2_system_part_comProcess_the_proc2_p_in","the_proc2_p_in","the_proc2_p_in_virtual_port",};
uint8_t pok_ports_identifiers[POK_CONFIG_NB_PORTS] = {the_cpu2_system_part_comProcess_the_proc2_p_in,the_proc2_p_in,the_proc2_p_in_virtual_port,};
uint8_t pok_ports_nb_destinations[POK_CONFIG_NB_PORTS] = {1,0,0,};
uint8_t* pok_ports_destinations[POK_CONFIG_NB_PORTS] = {the_cpu2_system_part_comProcess_the_proc2_p_in_deployment_destinations,NULL,NULL,};
uint8_t pok_ports_kind[POK_CONFIG_NB_PORTS] = {POK_PORT_KIND_QUEUEING,POK_PORT_KIND_QUEUEING,POK_PORT_KIND_VIRTUAL,};
