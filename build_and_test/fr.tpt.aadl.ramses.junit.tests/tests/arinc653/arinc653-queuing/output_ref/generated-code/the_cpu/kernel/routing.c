#include "routing.h"
#include "middleware/port.h"
#include <types.h>
uint8_t the_proc1_partport[1] = {the_proc1_p_out,};
uint8_t the_proc1_p_out_deployment_destinations[1] = {the_proc2_p_in_p_in_global,};
uint8_t the_proc2_partport[1] = {the_proc2_p_in,};
uint8_t pok_global_ports_to_local_ports[POK_CONFIG_NB_GLOBAL_PORTS] = {the_proc1_p_out,the_proc2_p_in,};
uint8_t pok_global_ports_to_bus[POK_CONFIG_NB_GLOBAL_PORTS] = {invalid_bus,invalid_bus,};
uint8_t pok_local_ports_to_global_ports[POK_CONFIG_NB_PORTS] = {the_proc1_p_out_p_out_global,the_proc2_p_in_p_in_global,};
uint8_t pok_ports_nodes[POK_CONFIG_NB_GLOBAL_PORTS] = {the_cpu,the_cpu,};
uint8_t pok_ports_nb_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {1,1,};
uint8_t* pok_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {the_proc1_partport,the_proc2_partport,};
char* pok_ports_names[POK_CONFIG_NB_PORTS] = {"the_proc1_p_out","the_proc2_p_in",};
uint8_t pok_ports_identifiers[POK_CONFIG_NB_PORTS] = {the_proc1_p_out,the_proc2_p_in,};
uint8_t pok_ports_nb_destinations[POK_CONFIG_NB_PORTS] = {1,0,};
uint8_t* pok_ports_destinations[POK_CONFIG_NB_PORTS] = {the_proc1_p_out_deployment_destinations,NULL,};
uint8_t pok_ports_kind[POK_CONFIG_NB_PORTS] = {POK_PORT_KIND_QUEUEING,POK_PORT_KIND_QUEUEING,};
